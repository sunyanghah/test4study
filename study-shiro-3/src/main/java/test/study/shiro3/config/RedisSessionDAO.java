package test.study.shiro3.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisSessionDAO extends AbstractSessionDAO {

    private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

    private static final String keyPrefix = "shiro:token:";

    private RedisTemplate<String,Object> redisTemplate;

    public RedisSessionDAO(RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * save/update session
     * @param session
     * @throws UnknownSessionException
     */
    @Override
    public void update(Session session) throws UnknownSessionException {

        this.saveSession(session);

    }

    /**
     * delete session
     * @param session
     */
    @Override
    public void delete(Session session) {

        if (session == null || session.getId() == null) {
            logger.error("session or session id is null");
            return;
        }

        redisTemplate.delete(getRedisSessionKey(session.getId()));

    }

    /**
     * get all active sessions
     * @return
     */
    @Override
    public Collection<Session> getActiveSessions() {

        Set<Session> sessions = new HashSet<Session>();
        try {
            Set<String> keys = redisTemplate.keys(this.keyPrefix + "*");
            if (keys != null && keys.size() > 0) {
                for (String key:keys) {
                    Session s = (Session) redisTemplate.opsForValue().get(key);
                    sessions.add(s);
                }
            }
        } catch (Exception e) {
            logger.error("get active sessions error.");
        }
        return sessions;
    }

    @Override
    protected Serializable doCreate(Session session) {

        if (session == null) {
            logger.error("session is null");
            throw new UnknownSessionException("session is null");
        }
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
        return sessionId;
    }

    /**
     * I change
     * @param sessionId
     * @return
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {

        if (sessionId == null) {
            logger.warn("session id is null");
            return null;
        }

        String sessionRedisKey = getRedisSessionKey(sessionId);
        logger.debug("read session: " + sessionRedisKey + " from Redis");
        Session session =  (Session) redisTemplate.opsForValue().get(sessionRedisKey);

        return session;
    }

    private String getRedisSessionKey(Serializable sessionId) {
        return this.keyPrefix + sessionId;
    }

    private void saveSession(Session session) throws UnknownSessionException {
        if (session == null || session.getId() == null) {
            logger.error("session or session id is null");
            throw new UnknownSessionException("session or session id is null");
        }

        redisTemplate.opsForValue().set(getRedisSessionKey(session.getId()), session,20, TimeUnit.MINUTES);

    }
}
