package test.study.algorithm;

/**
 * Created by dell on 2019/9/2.
 * @author dell
 */
public class Manacher {


    public static void main(String[] args) throws Exception{
        String str = "baabcfslfjlsdffffdssssdfwewiweuerin239sddfksdflndsfffffffffyffffffffs" +
                "dsasffa323rsfsdlsafjkansdlfnsdlfo233rwlesldflkasj3orlsflanh3ohroshfsnandfajfh" +
                "sdfaaaaaaaaaaaaaaaaaaaaytydaaaaaaaafjjfjfjfjfjfjdsnsnnsndnfnsndfekekekekwlslllllllllllllllsafafda" +
                "sdaf;;;;;;;;;;;;;;;;;;;;fsdfsafdafsadfasdffffffwefsdfaasfwefsafasfaefsfaasdfasfadsafafasfa" +
                "faasdf,sxuxujxuxuxjdjfsdfasafafafsafsan3nrk2kfffffffeffffffffttffffffffffsfdaccc" +
                "sdfsaeeeeeeeeeddddddddddffffdddeeeeeeeeeeejeeeeeeeeeeeeeeggsadsfadsafadsfsfsaxcxvxccvdfsfwerwer233ese" +
                "sat4w34ret34rfddr5trgfgy76yhg43wesd45hgtr545ery234t53nsnfsnffffffffffffffsd8sd8sd8f8jsjsjsjsjdsjsj" +
                "ssdd8dsiwjsksdhfjkadfjaskjfks;jaf;ksnxcm,nvxsfje;fjsf/af/ajfifjxpiuiwejr;kn;naf;jas;dfjka;fksdajfoahj" +
                "safajsfdk;jsfjiwoeifj023ur932u4wifjskdjffffffffffffffffhfffffffsiiiiiiiiiiiiiiii23423992i2k2l2k2kasdslsdl" +
                "sksdwe2323923823423jsfkkdffffffffffusssssssssssn233uwee2382822020233allllllsdmdsmduu82382382873uweewjsddjdfsddm" +
                "sjsdjaksdkaksdajfjxccmccjdjskzkzkuwuqwujajhcvbvbvhfhfhgjgnmvnvnvbcbdgggghsafhesjfdshjfjwhefjsnalfjshfljsans" +
                "hjlahdsfjhslhfuhwljfnldsbabvlbvlhlhldsfsanz.xmcnvzxlfhasjfnqm.wenfd.sflkjas;fs;djfkhsdafsamsne.ncpajsdkfa" +
                "j;;sjdfpisjkanefjshaidlsjllkxzkjsk;dfj;ajepiafnssa;nf;asjkfjdsakfnxzn;xkjzv;ksankfdnksaj;fakfksanfsna" +
                "ansd;fkja;ksdjiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksnk;jjfaskdfjajf;sadkjfk;anf;snsfasdxa" +
                "sjfasodfsddjdafpsdjdapfsdapdfjwekqelfajsd;fja;sdjfksasjdf;sadjlansdfadafsafsajfksddj;dfksjafiejia;dk;fj" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf" +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78s8f8s0as8d7f88wasdjfkjsidfueasfljsflsjdlfjsldjflsjafljdlajflajslfjakfjalj3lj22" +
                "sfsajs;kdjfksfkahxjxjxjjskeeeeeeeeeeeeejfkjsk;ajf;asjfipahf;haihfuahfjanjlfsan.dnz.mxnkvkxvnxzkgghewwru" +
                "ahhfjasjdlhfuh82u34i3jpiyfisajsdfpaihpfaj;dfiaihsehrfpashf;isafaufihsafhfiypasuirajpjefiasjdfianaw3jadfa" +
                "sddfasijekhadfpiajfpisdduaifjafajlshflzhsjenalsjelshjaehlahsejafhaljfhjsdlhfjlsafhlsafhjsalfhjafhsdldafh" +
                "fajfhlshduwhaf[asf[a-9wfhasfua'fasfihasfhuh32jb23jj32jlasjldhfsajndfasfhadslhfsajlbjzbjzhjcbvjhslahjaherjlh" +
                "fahjsdlhfajhoauhajlhsauehjsaldxkxkxkdddddddtdddddddddfhhhhhhhhhrhhhhhhhdddddfsjafhlaufhaljdhalfhallfsajlfdha" +
                "afdiahspdfhasdpifaipsudfsiajfas;djsifjisajfsdjfiaidfjwjwqweahshdlfjhausdfyouaysudfoysuaofdyuaohsdofhuaao" +
                "lkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;dfj;ajepiafnssa;nf;asjkfjdsakfnxzn;xkjzv;ksankfdnksaj;fakfksanfsna" +
                "ansd;fkja;ksdjiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksnk;jjfaskdfjajf;sadkjfk;anf;snsfasdxa" +
                "sjfasodfsddjdafpsdjdapfsdapdfjwekqelfajsd;fja;sdjfksasjdf;sadjlansdfadafsafsajfksddj;dfksjafiejia;dk;fj" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf"  +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78slkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;8f8slkxzkdsfaeeelkxzkdsfaeeeeee" +
                "eeeeeeeeeeeeeeeeeeejsk;eeeeeeeeeeeeeggeeeeeeeeejskiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksn" +
                "sssssssssscccccccccjccccccccccdddddddddgddddddsdsdfffffffffsfadsasadfasdfasdffffffffffjfffffffsdddddddddddd" +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78s8f8s0as8d7f88wasdjfkjsidfueasfljsflsjdlfjsldjflsjafljdlajflajslfjakfjalj3lj22" +
                "sfsajs;kdjfksfkahxjxjxjjskeeeeeeeeeeeeejfkjsk;ajf;asjfipahf;haihfuahfjanjlfsan.dnz.mxnkvkxvnxzkgghewwru" +
                "ahhfjasjdlhfuh82u34i3jpiyfisajsdfpaihpfaj;dfiaihsehrfpashf;isafaufihsafhfiypasuirajpjefiasjdfianaw3jadfa" +
                "sddfasijekhadfpiajfpisdduaifjafajlshflzhsjenalsjelshjaehlahsejafhaljfhjsdlhfjlsafhlsafhjsalfhjafhsdldafh" +
                "fajfhlshduwhaf[asf[a-9wfhasfua'fasfihasfhuh32jb23jj32jlasjldhfsajndfasfhadslhfsajlbjzbjzhjcbvjhslahjaherjlh" +
                "fahjsdlhfajhoauhajlhsauehjsaldxkxkxkdddddddtdddddddddfhhhhhhhhhrhhhhhhhdddddfsjafhlaufhaljdhalfhallfsajlfdha" +
                "afdiahspdfhasdpifaipsudfsiajfas;djsifjisajfsdjfiaidfjwjwqweahshdlfjhausdfyouaysudfoysuaofdyuaohsdofhuaao" +
                "lkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;dfj;ajepiafnssa;nf;asjkfjdsakfnxzn;xkjzv;ksankfdnksaj;fakfksanfsna" +
                "ansd;fkja;ksdjiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksnk;jjfaskdfjajf;sadkjfk;anf;snsfasdxa" +
                "sjfasodfsddjdafpsdjdapfsdapdfjwekqelfajsd;fja;sdjfksasjdf;sadjlansdfadafsafsajfksddj;dfksjafiejia;dk;fj" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf"  +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78slkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;8f8slkxzkdsfaeeelkxzkdsfaeeeeee" +
                "eeeeeeeeeeeeeeeeeeejsk;eeeeeeeeeeeeeggeeeeeeeeejskiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksn" +
                "sssssssssscccccccccjccccccccccdddddddddgddddddsdsdfffffffffsfadsasadfasdfasdffffffffffjfffffffsdddddddddddd" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf" +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78s8f8s0as8d7f88wasdjfkjsidfueasfljsflsjdlfjsldjflsjafljdlajflajslfjakfjalj3lj22" +
                "sfsajs;kdjfksfkahxjxjxjjskeeeeeeeeeeeeejfkjsk;ajf;asjfipahf;haihfuahfjanjlfsan.dnz.mxnkvkxvnxzkgghewwru" +
                "ahhfjasjdlhfuh82u34i3jpiyfisajsdfpaihpfaj;dfiaihsehrfpashf;isafaufihsafhfiypasuirajpjefiasjdfianaw3jadfa" +
                "sddfasijekhadfpiajfpisdduaifjafajlshflzhsjenalsjelshjaehlahsejafhaljfhjsdlhfjlsafhlsafhjsalfhjafhsdldafh" +
                "fajfhlshduwhaf[asf[a-9wfhasfua'fasfihasfhuh32jb23jj32jlasjldhfsajndfasfhadslhfsajlbjzbjzhjcbvjhslahjaherjlh" +
                "fahjsdlhfajhoauhajlhsauehjsaldxkxkxkdddddddtdddddddddfhhhhhhhhhrhhhhhhhdddddfsjafhlaufhaljdhalfhallfsajlfdha" +
                "afdiahspdfhasdpifaipsudfsiajfas;djsifjisajfsdjfiaidfjwjwqweahshdlfjhausdfyouaysudfoysuaofdyuaohsdofhuaao" +
                "lkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;dfj;ajepiafnssa;nf;asjkfjdsakfnxzn;xkjzv;ksankfdnksaj;fakfksanfsna" +
                "ansd;fkja;ksdjiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksnk;jjfaskdfjajf;sadkjfk;anf;snsfasdxa" +
                "sjfasodfsddjdafpsdjdapfsdapdfjwekqelfajsd;fja;sdjfksasjdf;sadjlansdfadafsafsajfksddj;dfksjafiejia;dk;fj" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf"  +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78slkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;8f8slkxzkdsfaeeelkxzkdsfaeeeeee" +
                "eeeeeeeeeeeeeeeeeeejsk;eeeeeeeeeeeeeggeeeeeeeeejskiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksn" +
                "sssssssssscccccccccjccccccccccdddddddddgddddddsdsdfffffffffsfadsasadfasdfasdffffffffffjfffffffsdddddddddddd" +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78s8f8s0as8d7f88wasdjfkjsidfueasfljsflsjdlfjsldjflsjafljdlajflajslfjakfjalj3lj22" +
                "sfsajs;kdjfksfkahxjxjxjjskeeeeeeeeeeeeejfkjsk;ajf;asjfipahf;haihfuahfjanjlfsan.dnz.mxnkvkxvnxzkgghewwru" +
                "ahhfjasjdlhfuh82u34i3jpiyfisajsdfpaihpfaj;dfiaihsehrfpashf;isafaufihsafhfiypasuirajpjefiasjdfianaw3jadfa" +
                "sddfasijekhadfpiajfpisdduaifjafajlshflzhsjenalsjelshjaehlahsejafhaljfhjsdlhfjlsafhlsafhjsalfhjafhsdldafh" +
                "fajfhlshduwhaf[asf[a-9wfhasfua'fasfihasfhuh32jb23jj32jlasjldhfsajndfasfhadslhfsajlbjzbjzhjcbvjhslahjaherjlh" +
                "fahjsdlhfajhoauhajlhsauehjsaldxkxkxkdddddddtdddddddddfhhhhhhhhhrhhhhhhhdddddfsjafhlaufhaljdhalfhallfsajlfdha" +
                "afdiahspdfhasdpifaipsudfsiajfas;djsifjisajfsdjfiaidfjwjwqweahshdlfjhausdfyouaysudfoysuaofdyuaohsdofhuaao" +
                "lkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;dfj;ajepiafnssa;nf;asjkfjdsakfnxzn;xkjzv;ksankfdnksaj;fakfksanfsna" +
                "ansd;fkja;ksdjiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksnk;jjfaskdfjajf;sadkjfk;anf;snsfasdxa" +
                "sjfasodfsddjdafpsdjdapfsdapdfjwekqelfajsd;fja;sdjfksasjdf;sadjlansdfadafsafsajfksddj;dfksjafiejia;dk;fj" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf"  +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78slkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;8f8slkxzkdsfaeeelkxzkdsfaeeeeee" +
                "eeeeeeeeeeeeeeeeeeejsk;eeeeeeeeeeeeeggeeeeeeeeejskiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksn" +
                "sssssssssscccccccccjccccccccccdddddddddgddddddsdsdfffffffffsfadsasadfasdfasdffffffffffjfffffffsdddddddddddd" +
                "dsasffa323rsfsdlsafjkansdlfnsdlfo233rwlesldflkasj3orlsflanh3ohroshfsnandfajfh" +
                "sdfaaaaaaaaaaaaaaaaaaaaytydaaaaaaaafjjfjfjfjfjfjdsnsnnsndnfnsndfekekekekwlslllllllllllllllsafafda" +
                "sdaf;;;;;;;;;;;;;;;;;;;;fsdfsafdafsadfasdffffffwefsdfaasfwefsafasfaefsfaasdfasfadsafafasfa" +
                "faasdf,sxuxujxuxuxjdjfsdfasafafafsafsan3nrk2kfffffffeffffffffttffffffffffsfdaccc" +
                "sdfsaeeeeeeeeeddddddddddffffdddeeeeeeeeeeejeeeeeeeeeeeeeeggsadsfadsafadsfsfsaxcxvxccvdfsfwerwer233ese" +
                "sat4w34ret34rfddr5trgfgy76yhg43wesd45hgtr545ery234t53nsnfsnffffffffffffffsd8sd8sd8f8jsjsjsjsjdsjsj" +
                "ssdd8dsiwjsksdhfjkadfjaskjfks;jaf;ksnxcm,nvxsfje;fjsf/af/ajfifjxpiuiwejr;kn;naf;jas;dfjka;fksdajfoahj" +
                "safajsfdk;jsfjiwoeifj023ur932u4wifjskdjffffffffffffffffhfffffffsiiiiiiiiiiiiiiii23423992i2k2l2k2kasdslsdl" +
                "sksdwe2323923823423jsfkkdffffffffffusssssssssssn233uwee2382822020233allllllsdmdsmduu82382382873uweewjsddjdfsddm" +
                "sjsdjaksdkaksdajfjxccmccjdjskzkzkuwuqwujajhcvbvbvhfhfhgjgnmvnvnvbcbdgggghsafhesjfdshjfjwhefjsnalfjshfljsans" +
                "hjlahdsfjhslhfuhwljfnldsbabvlbvlhlhldsfsanz.xmcnvzxlfhasjfnqm.wenfd.sflkjas;fs;djfkhsdafsamsne.ncpajsdkfa" +
                "j;;sjdfpisjkanefjshaidlsjllkxzkjsk;dfj;ajepiafnssa;nf;asjkfjdsakfnxzn;xkjzv;ksankfdnksaj;fakfksanfsna" +
                "ansd;fkja;ksdjiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksnk;jjfaskdfjajf;sadkjfk;anf;snsfasdxa" +
                "sjfasodfsddjdafpsdjdapfsdapdfjwekqelfajsd;fja;sdjfksasjdf;sadjlansdfadafsafsajfksddj;dfksjafiejia;dk;fj" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf" +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78s8f8s0as8d7f88wasdjfkjsidfueasfljsflsjdlfjsldjflsjafljdlajflajslfjakfjalj3lj22" +
                "sfsajs;kdjfksfkahxjxjxjjskeeeeeeeeeeeeejfkjsk;ajf;asjfipahf;haihfuahfjanjlfsan.dnz.mxnkvkxvnxzkgghewwru" +
                "ahhfjasjdlhfuh82u34i3jpiyfisajsdfpaihpfaj;dfiaihsehrfpashf;isafaufihsafhfiypasuirajpjefiasjdfianaw3jadfa" +
                "sddfasijekhadfpiajfpisdduaifjafajlshflzhsjenalsjelshjaehlahsejafhaljfhjsdlhfjlsafhlsafhjsalfhjafhsdldafh" +
                "fajfhlshduwhaf[asf[a-9wfhasfua'fasfihasfhuh32jb23jj32jlasjldhfsajndfasfhadslhfsajlbjzbjzhjcbvjhslahjaherjlh" +
                "fahjsdlhfajhoauhajlhsauehjsaldxkxkxkdddddddtdddddddddfhhhhhhhhhrhhhhhhhdddddfsjafhlaufhaljdhalfhallfsajlfdha" +
                "afdiahspdfhasdpifaipsudfsiajfas;djsifjisajfsdjfiaidfjwjwqweahshdlfjhausdfyouaysudfoysuaofdyuaohsdofhuaao" +
                "lkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;dfj;ajepiafnssa;nf;asjkfjdsakfnxzn;xkjzv;ksankfdnksaj;fakfksanfsna" +
                "ansd;fkja;ksdjiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksnk;jjfaskdfjajf;sadkjfk;anf;snsfasdxa" +
                "sjfasodfsddjdafpsdjdapfsdapdfjwekqelfajsd;fja;sdjfksasjdf;sadjlansdfadafsafsajfksddj;dfksjafiejia;dk;fj" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf"  +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78slkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;8f8slkxzkdsfaeeelkxzkdsfaeeeeee" +
                "eeeeeeeeeeeeeeeeeeejsk;eeeeeeeeeeeeeggeeeeeeeeejskiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksn" +
                "sssssssssscccccccccjccccccccccdddddddddgddddddsdsdfffffffffsfadsasadfasdfasdffffffffffjfffffffsdddddddddddd" +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78s8f8s0as8d7f88wasdjfkjsidfueasfljsflsjdlfjsldjflsjafljdlajflajslfjakfjalj3lj22" +
                "sfsajs;kdjfksfkahxjxjxjjskeeeeeeeeeeeeejfkjsk;ajf;asjfipahf;haihfuahfjanjlfsan.dnz.mxnkvkxvnxzkgghewwru" +
                "ahhfjasjdlhfuh82u34i3jpiyfisajsdfpaihpfaj;dfiaihsehrfpashf;isafaufihsafhfiypasuirajpjefiasjdfianaw3jadfa" +
                "sddfasijekhadfpiajfpisdduaifjafajlshflzhsjenalsjelshjaehlahsejafhaljfhjsdlhfjlsafhlsafhjsalfhjafhsdldafh" +
                "fajfhlshduwhaf[asf[a-9wfhasfua'fasfihasfhuh32jb23jj32jlasjldhfsajndfasfhadslhfsajlbjzbjzhjcbvjhslahjaherjlh" +
                "fahjsdlhfajhoauhajlhsauehjsaldxkxkxkdddddddtdddddddddfhhhhhhhhhrhhhhhhhdddddfsjafhlaufhaljdhalfhallfsajlfdha" +
                "afdiahspdfhasdpifaipsudfsiajfas;djsifjisajfsdjfiaidfjwjwqweahshdlfjhausdfyouaysudfoysuaofdyuaohsdofhuaao" +
                "lkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;dfj;ajepiafnssa;nf;asjkfjdsakfnxzn;xkjzv;ksankfdnksaj;fakfksanfsna" +
                "ansd;fkja;ksdjiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksnk;jjfaskdfjajf;sadkjfk;anf;snsfasdxa" +
                "sjfasodfsddjdafpsdjdapfsdapdfjwekqelfajsd;fja;sdjfksasjdf;sadjlansdfadafsafsajfksddj;dfksjafiejia;dk;fj" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf"  +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78slkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;8f8slkxzkdsfaeeelkxzkdsfaeeeeee" +
                "eeeeeeeeeeeeeeeeeeejsk;eeeeeeeeeeeeeggeeeeeeeeejskiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksn" +
                "sssssssssscccccccccjccccccccccdddddddddgddddddsdsdfffffffffsfadsasadfasdfasdffffffffffjfffffffsdddddddddddd" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf" +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78s8f8s0as8d7f88wasdjfkjsidfueasfljsflsjdlfjsldjflsjafljdlajflajslfjakfjalj3lj22" +
                "sfsajs;kdjfksfkahxjxjxjjskeeeeeeeeeeeeejfkjsk;ajf;asjfipahf;haihfuahfjanjlfsan.dnz.mxnkvkxvnxzkgghewwru" +
                "ahhfjasjdlhfuh82u34i3jpiyfisajsdfpaihpfaj;dfiaihsehrfpashf;isafaufihsafhfiypasuirajpjefiasjdfianaw3jadfa" +
                "sddfasijekhadfpiajfpisdduaifjafajlshflzhsjenalsjelshjaehlahsejafhaljfhjsdlhfjlsafhlsafhjsalfhjafhsdldafh" +
                "fajfhlshduwhaf[asf[a-9wfhasfua'fasfihasfhuh32jb23jj32jlasjldhfsajndfasfhadslhfsajlbjzbjzhjcbvjhslahjaherjlh" +
                "fahjsdlhfajhoauhajlhsauehjsaldxkxkxkdddddddtdddddddddfhhhhhhhhhrhhhhhhhdddddfsjafhlaufhaljdhalfhallfsajlfdha" +
                "afdiahspdfhasdpifaipsudfsiajfas;djsifjisajfsdjfiaidfjwjwqweahshdlfjhausdfyouaysudfoysuaofdyuaohsdofhuaao" +
                "lkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;dfj;ajepiafnssa;nf;asjkfjdsakfnxzn;xkjzv;ksankfdnksaj;fakfksanfsna" +
                "ansd;fkja;ksdjiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksnk;jjfaskdfjajf;sadkjfk;anf;snsfasdxa" +
                "sjfasodfsddjdafpsdjdapfsdapdfjwekqelfajsd;fja;sdjfksasjdf;sadjlansdfadafsafsajfksddj;dfksjafiejia;dk;fj" +
                "sakdfka;dksaknwe,rnjjsi233823828kskssssssssafksaf;jskfksafknmxn.nz.cvkjjskaeknafn;ksja;fjaskjfiajeiwajfk;lsdaf"  +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78slkxzkdsfaeeeeeeeeeeeeeeeeeeeeeeeeejsk;8f8slkxzkdsfaeeelkxzkdsfaeeeeee" +
                "eeeeeeeeeeeeeeeeeeejsk;eeeeeeeeeeeeeggeeeeeeeeejskiajdxkzkfafa'fjijdkasnfkanew;nf;ajsd[fsdfakdsajfkjaksn" +
                "sssssssssscccccccccjccccccccccdddddddddgddddddsdsdfffffffffsfadsasadfasdfasdffffffffffjfffffffsdddddddddddd" +
                "asdfkj;sajfken3n23i2i3p2uq83u8r78s8f8s0as8d7f88wasdjfkjsidfueasfljsflsjdlfjsldjflsjafljdlajflajslfjakfjalj3lj22" +
                "sfsajs;kdjfksfkahxjxjxjjskeeeeeeeeeeeeejfkjsk;ajf;asjfipahf;haihfuahfjanjlfsan.dnz.mxnkvkxvnxzkgghewwru" +
                "ahhfjasjdlhfuh82u34i3jpiyfisajsdfpaihpfaj;dfiaihsehrfpashf;isafaufihsafhfiypasuirajpjefiasjdfianaw3jadfa" +
                "sddfasijekhadfpiajfpisdduaifjafajlshflzhsjenalsjelshjaehlahsejafhaljfhjsdlhfjlsafhlsafhjsalfhjafhsdldafh" +
                "fajfhlshduwhaf[asf[a-9wfhasfua'fasfihasfhuh32jb23jj32jlasjldhfsajndfasfhadslhfsajlbjzbjzhjcbvjhslahjaherjlh" +
                "fahjsdlhfajhoauhajlhsauehjsaldxkxkxkdddddddtdddddddddfhhhhhhhhhrhhhhhhhdddddfsjafhlaufhaljdhalfhallfsajlfdha" +
                "cccccxzfffffffffffjffffffsdfsasdfadfaaerrrrrrrrrrrgrrrrrrrrrrrreeeeeeeeeeejeeeeeeeeeeeeek;jjfaskdfjajf" +
                "sdfkkkkkkkkkkkkkkkkksdfasdfijsaf;ksjakenknksjdfisjaisaslenflsndfjisaojewlrsafdsakeidsadkjfk;anf;sn";

        String str2 = "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba"+
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" +
                "abcdefghijklmnopqrstuvwxyz1234567891011121314151617181920" +
                "aaabacadaeafagahaiajakalamananamalakajaiahagafaeadacabaa" +
                "2019181716151413121110987654321zyxwvutsrqponmlkjihgfedcba" ;


        String str3 = "adaelelefd";

//        long start1 = System.currentTimeMillis();
//        test1(str);
//        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        test2(str2);
        long end2 = System.currentTimeMillis();

        long start3 = System.currentTimeMillis();
        test3(str2);
        long end3 = System.currentTimeMillis();

        long manacherStart = System.currentTimeMillis();
        manacher(str2);
        long manacherEnd = System.currentTimeMillis();

//        System.out.println("test1使用："+(end1-start1));
        System.out.println("test2使用："+(end2-start2));
        System.out.println("test3使用："+(end3-start3));
        System.out.println("manch使用："+(manacherEnd-manacherStart));
    }

    private static void test1(String str) throws Exception{
        String longestStr = "";

        for (int i = 0;i<str.length()-1;i++){
            for (int j = i+1;j<=str.length();j++){
                String substring = str.substring(i, j);
                if (checkPlalindrome(substring) && (j-i)>longestStr.length()){
                    longestStr = substring;
                }
            }
        }
        if (longestStr.length()>0) {
            System.out.println("test1最长的回文串是：" + longestStr);
        }else {
            System.out.println("test1没有找到回文串");
        }
    }
    private static boolean checkPlalindrome(String str) throws Exception{
        if (str != null && str.length()>1){
            for (int i = 0;i<str.length()/2;i++){
                if (str.charAt(i) != str.charAt(str.length()-(i+1))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static void test2(String str) throws Exception{
        // 都处理成奇数 让 abba 变成 #a#b#b#a#
        str = preHandleString(str);
        int len = str.length();
        // 初始化左右索引
        int left = len-1,right = 0;
        // 遍历字符串
        for (int i = 1;i<len;i++){
            // 向前后遍历，前至索引0 后至字符串末
            for (int j=1;i-j>=0 && i+j<len;j++) {
                // 如果是回文，并且比现在记录的回文更长，则记录此回文串索引
                if (str.charAt(i - j) == str.charAt(i + j)) {
                    if (((i+j)-(i-j)) > (right - left)){
                        left = i - j;
                        right = i + j;
                    }
                // 如果判断不是回文，则让下一个字符串为中心开始判断
                }else{
                    break;
                }
            }
        }
        // 根据记录的索引，取得最长的回文串
        String substring = str.substring(left, right + 1);
        // 去掉特殊符号
        StringBuilder rt = new StringBuilder();
        for (int i =0 ;i<substring.length();i++){
            if (i%2==1){
                rt.append(substring.charAt(i));
            }
        }
        System.out.println("test2最长的回文串是："+rt.toString());
    }


    private static void test3(String s) {
        // 先预处理字符串
        String str = preHandleString(s);
        // 处理后的字串长度
        int len = str.length();
        // 右边界
        int rightSide = 0;
        // 右边界对应的回文串中心
        int rightSideCenter = 0;
        // 保存以每个字符为中心的回文长度一半（向下取整）
        int[] halfLenArr = new int[len];
        // 记录回文中心
        int center = 0;
        // 记录最长回文长度
        int longestHalf = 0;
        for(int i = 0; i < len; i++) {
            // 是否需要中心扩展
            boolean needCalc = true;
            // 如果在右边界的覆盖之内
            if(rightSide > i) {
                // 计算相对rightSideCenter的对称位置
                int leftCenter = 2 * rightSideCenter - i;
                // 根据回文性质得到的结论
                halfLenArr[i] = halfLenArr[leftCenter];
                // 如果超过了右边界，进行调整
                if(i + halfLenArr[i] > rightSide) {
                    halfLenArr[i] = rightSide - i;
                }
                // 如果根据已知条件计算得出的最长回文小于右边界，则不需要扩展了
                if(i + halfLenArr[leftCenter] < rightSide) {
                    // 直接推出结论
                    needCalc = false;
                }
            }
            // 中心扩展
            if(needCalc) {
                while(i - 1 - halfLenArr[i] >= 0 && i + 1 + halfLenArr[i] < len) {
                    if(str.charAt(i + 1 + halfLenArr[i]) == str.charAt(i - 1 - halfLenArr[i])) {
                        halfLenArr[i]++;
                    } else {
                        break;
                    }
                }
                // 更新右边界及中心
                rightSide = i + halfLenArr[i];
                rightSideCenter = i;
                // 记录最长回文串
                if(halfLenArr[i] > longestHalf) {
                    center = i;
                    longestHalf = halfLenArr[i];
                }
            }
        }
        // 去掉之前添加的#
        StringBuffer sb = new StringBuffer();
        for(int i = center - longestHalf + 1; i <= center + longestHalf; i += 2) {
            sb.append(str.charAt(i));
        }
        System.out.println("test3最长的回文串是：" + sb.toString());
    }

    /**
     * 这里开头和结尾也要必须是符号，不然碰到 aba ，tabam这两种不同情形的串时
     * 最后找到的回文串将会是 a#b#a 与  #a#b#a# 这两种，
     * 会有问题。
     * @param str
     * @return
     */
    private static String preHandleString(String str) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0;i<str.length();i++){
            sb.append(str.charAt(i)).append("#");
        }
        return sb.toString();
    }

    // ddabbac
    private static void manacher(String str){
        // #d#d#a#b#e#b#a#c#
        // 0123456789abcdefg
        str = preHandleString(str);
        int len = str.length();
        int rightSide = 0;
        int rightSideCenter = 0;
        int longest = 0;
        int center = 0;
        int[] halfLenArr = new int[len];
        for (int i =0;i<len;i++){
            boolean needKz = true;
            // 右羽翼之内
            if (rightSide > i){
                int left = 2*rightSideCenter - i;
                halfLenArr[i] = halfLenArr[left];
                // 超了右羽翼
                if (halfLenArr[i] + i > rightSide){
                    halfLenArr[i] = rightSide - i;
                // 没超就直接得出结论
                }else if (halfLenArr[left] + i < rightSide){
                    needKz = false;
                }
            }
            // 需要扩展
            if (needKz){
                while (i - 1 - halfLenArr[i] > 0 && i + 1 + halfLenArr[i] < len){
                    if (str.charAt(i-1-halfLenArr[i]) == str.charAt(i+1+halfLenArr[i])){
                        halfLenArr[i]++;
                    }else {
                        break;
                    }
                }
                rightSide = i + halfLenArr[i];
                rightSideCenter = i;
                if (halfLenArr[i] > longest){
                    longest = halfLenArr[i];
                    center = i;
                }
            }
        }
        // 去掉之前添加的#
        StringBuffer sb = new StringBuffer();
        for(int i = center - longest + 1; i <= center + longest; i += 2) {
            sb.append(str.charAt(i));
        }
        System.out.println("manch最长的回文串是：" + sb.toString());

    }

}
