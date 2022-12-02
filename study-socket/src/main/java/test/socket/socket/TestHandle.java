package test.socket.socket;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/9/8 14:59
 */
@Component
@Data
public class TestHandle {

    private List<Session> sessionList = new ArrayList<>();

}
