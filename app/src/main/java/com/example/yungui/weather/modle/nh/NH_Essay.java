package com.example.yungui.weather.modle.nh;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/8/10.
 */

public class NH_Essay {

    /**
     * res : 0
     * data : {"content_id":"1701","hp_title":"香港的铺子，好景常在","sub_title":"","hp_author":"葛亮","auth_it":"最会说故事的小说家。《北鸢》《朱雀》热销中。","hp_author_introduce":"责任编辑：小影","hp_content":"<br>\r\n<img alt=\"\" src=\"http://image.wufazhuce.com/FqVrEbUC-uCvvw-p6xtUM-vgQH4Q?imageView2/2/w/394\" style=\"height:262px; width:394px\" /><br>\r\n<br>\r\n1.<br>\r\n现在住的地方，若用地产中介的口气﹐便说是\u201c旺中带静\u201d的。这街的形状﹐是一个长长的弧形﹐好像一枚新月。街道两边是一些有了年岁的楼宇。静的确是静的﹐其实闹市并不远。因为这街的形状﹐自成一统﹐便涤清了外界的许多声响。或许也是因为老旧﹐最初并不打算长居。因为家中曾经的变故﹐租住这里﹐是为了能在中午赶回家来﹐陪母亲吃饭。后来竟就住了下来﹐一住就是几年。<br>\r\n <br>\r\n一则是因为房东人实在是很好。房东叶老先生，是上海人。据说当年出租的时候，他有自己的挑剔。但因为听说我是南京来的，引为老乡，竟然很爽快地答应下来。叶先生是五十年代来港创业的工厂主，时当壮年，现在说广东话也还带了浓浓的乡音。当时香港的大环境和后来的经济起飞尚有距离。<br>\r\n <br>\r\n所以，艰苦的日子也是经过了的。第一次的置业，便是在这里买下了几个单位。自己住过红磡、湾仔。老了，就搬回了这里。大约也是好静，又见得到老街坊吧。叶先生喜烹饪﹐兴起，会烧一些地道的本帮菜，送过来与我分享。又喜欢京剧，有很多京戏的影碟。有时候听得见隔壁的声响，最多的是《法门寺》。<br>\r\n <br>\r\n这出我不陌生。大约因为外公也喜欢。有一次他还特来邀我和他一起听。是一出《空城计》。他说他其实最喜欢的，是马连良和周信芳。谈起来，竟也知道年轻得多的于魁智。便又感叹，他来香港的时候，于还未出生呢﹐现在居然就在大陆当红了。说完后﹐自己去了里屋翻了半天﹐翻出一把京胡，沾满了尘土。他一面擦灰，一面说这京胡跟他来了香港，也老了。原先弦是上好的马鬃，断了，在这里竟再也配不上。现在勉勉强强装上了钢丝，只有凑合地听了。说完就拉起一曲《大登殿》，声音有些尖利，但力道却是足的。在这咿咿呀呀里，窗外暮色也低沉下去。我便有些爱这条街了。<br>\r\n <br>\r\n <br>\r\n2.<br>\r\n回忆起来，在香港也迁居了多次。早前在港岛的西区﹐第一个住处，在山道上，四周的风物似乎是让人喜爱的。早上推开窗子，遥遥地能北望到海和浓重的晨雾。下了楼﹐看得见有许多弯折的小道。傍晚的时候，和缓的风也是山上来的。夕阳的光线从法国梧桐的叶子里筛下来，落到地上是星星点点。间或又吹下一两朵洋紫荆或者合欢，便是这光斑中的一两点锦簇。景全是小景，因和日常相关，也更入眼入心。<br>\r\n <br>\r\n这些小道，都不起眼，其实是西区的血脉，内在有严整的秩序。街边琳琅的小铺，都是因地制宜，见缝插针。名号却时常分外地大，比方说\u201c贝多芬琴行\u201d ﹑\u201c刘海粟画院\u201d﹐ 通常却不过十米见方﹐大约也是香港寸土寸金的明证。<br>\r\n <br>\r\n靠着正街，是很陡峭的一条街，从般咸道落下，站在上方，目光直上直下，可一直通向德辅道。整条街都是石板铺筑的阶梯，密集集地下落，几乎有点壮观的意思。这里是很多香港电影取景的地方。<br>\r\n <br>\r\n我常去的是靠近山脚下的一爿旧书店。叫做\u201c平记\u201d。终年是一盏泛了蓝的日光灯，瓦数很小，并且闪烁不定。倚墙摆了几个通天大书架，生铁或是木的，里面有很多漫画，因为有些是限量版，待价而沽。香港有数不清的漫画收藏迷，真的有肯为一本上世纪七十年代出版的《龙虎门》出上好几旧水的（香港白话称一百元为\u201c一旧水\u201d）。这个书店却专有一个中文书架，间歇让人有意想不到的收获。在这书架上，我淘到过天地初版钟晓阳的《流年》，联文版的《喜福会》，王瑶先生的《中国新文学史纲》，甚至有一本五十年代出版的丰子恺《绘画鲁迅小说》，品相十分的好。后来这间店，大约也关了门。<br>\r\n <br>\r\n山脚的德辅道是电车道。电车也算是香港的一道景致，一九〇四年开通迄今，竟有一百多年了，缓缓来往于港岛北的坚尼地城至筲箕湾，还在做着实际的用途。这车在香港人的口中又叫做\u201c叮叮\u201d，是它行动时的声响。响起来，大约就是张爱玲说的\u201c市声\u201d。可电车声在上海却是听不见了。这车是谈不上效率可言的，所以车上除了观光客，便是些师奶与孩童﹐一律都是怡然的神情。<br>\r\n <br>\r\n沿着海﹐\u201c叮叮当当\u201d地驶过上环，再进入中环、金钟。\u201c中环速度\u201d也便在这声音里不情不愿地慢下来了。搭乘这车，会闻见浓郁的海味，这是海产街上的气味，来自鱼翅﹑海参﹑花胶与其他干货。绕过梅芳街上了荷里活道，便有了另一番天地。<br>\r\n <br>\r\n这条道路Hollywood Road的起源，是因早年种植在路旁的冬青树名，又有一说holly其实是一种榕树。无论如何﹐也是早于美国\u201c荷里活\u201d的产生。曾经陪一个朋友、王家卫的粉丝﹐专程来这里朝拜《重庆森林》里梁朝伟的住处。只是行人电梯附近很普通的中式唐楼。朋友不免失望，说相见不如怀念。<br>\r\n<br>\r\n<img alt=\"\" src=\"http://image.wufazhuce.com/FgXFbdxfO4me9Khn05sivVwDp_54?imageView2/2/w/394\" style=\"height:591px; width:394px\" /> <br>\r\n <br>\r\n这条街的声名，其实叫做古董街。错落着几十间极小的铺头。风格则一律清幽，又有烟火气，有点像南京的朝天宫，又整饬一些。没事的时候，我倒喜欢在这里逛一逛。东西多半是Chineseness，中国风，浓到化不开的。卷轴、陶瓷、漆器、都老旧得很。曾经看到一只紫檀木的明式小圈椅，手掌大小，细节入微，让人爱不忍释，价格亦甚为可观。倒是友人新婚，在这里买了两只葫芦，说是放在房间里作辟邪之用。葫芦上烙着一个人形，问起来，说是龙门派的王常月。这一派由丘处机所创，后来式微，到了王再复兴，已隔了几个世纪。若论避邪的功力，恐怕也减去几成了。<br>\r\n <br>\r\n年轻的也是有的，但依然是老调子。在这街道的拐角处，坐落着一间\u201c住好啲\u201d（G.O.D） 。本土设计师杨志超造出了生活的又一重海市蜃楼。老旧的印花布底裤﹐上世纪六十年代的铁皮水壶﹐发黄新闻纸图案的布艺躺椅﹐让人恍若隔世。却是二十一世纪新新人类的心头好。拐角里摆着本土的艺术杂志和《诚品好读》，每次去，总要翻上一翻。也就忍不住买上一两件东西，因为它们摆在那里恰如其分得如此悦目。但买回去，在自己的住处﹐却成了零余品。别看这表面灰厚的风格，却有着锋利的构思。这间家用品店被警方前后检控过两次，一次二〇〇四年时候推出 \u201cDelay no more\u201d 字样的产品，因为和粤语的粗口谐音，了众怒。一次是二〇〇七年，因为检获印有\u201c拾肆K\u201d字样的衬衣及明信片，涉嫌有关三合会社团14K，是成心要和社会不和谐。<br>\r\n <br>\r\n和谐的也是有的，到了中环皇后大道中，几间老字号，各据一方，各安其是。士丹利街的陆羽茶室，黑色的老吊扇，仍然缓慢地旋转。将时间转慢了，将香港人的心也转慢了。咬上一口蚧黄灌汤饺，喝上一口普洱，便不知归去。世人都说神仙好，惟有\u201c莲香\u201d忘不了。慕名来的，先都失望，都说破落。待吃上一口贵妃鸡，便都说来对了。来对了，便再要来，却见它越发破落了。再看威灵顿街上，\u201c镛记\u201d的排场是大的。朋友来香港，点名要吃这一家。例牌是烧鹅，好吃的却是顺德三宝，清水牛腩。<br>\r\n <br>\r\n这里靠德己立街已经很近了，窄窄的一条弯道，就进了兰桂坊。于我而言，这实在是个应景的地方，如果不是新年倒数，如果不是郁闷太甚，平日对汹涌的人潮避之不及。鬼佬、中产、猫三猫四、出出没没。倒是也有好地方。有一间极安静的酒吧叫Milk。或许也是生意不好，居然在热闹里渗出清冷来。一个面目严肃的菲律宾歌手唱着Love me tender。歌声也很清冷。<br>\r\n <br>\r\n3.<br>\r\n 后来，终于从山道上搬了，搬进了规整的校园区。忙于研究与论文，这些地方便也很少去。去得少了，心思便也淡了。后来就像是没了瘾。先是在研究生堂住，前见海，后见山，是极其好的清静地。<br>\r\n <br>\r\n在这里﹐我开始写我的长篇小说《朱雀》，也是恰逢其时。此后搬到叫做STARR的校舍。楼层住得很高，也面海，竟可以看到驻港部队的空军演习。对面是何东夫人堂，男学生经常情不自禁地望过去，是间女生舍堂。我看到时，早已翻了新。旧时的格局是可笑的贵族风，房内两张床，一张是女学生的，一张是给随行的女佣。后来终究要拆，拆之前也依恋。张婉婷便说，那好，我来拍一出戏。便是《玻璃之城》。都说舒淇将港大女生演绎得惟妙惟肖。败笔是黎明，港大的男孩子，可没有这样老实头的。<br>\r\n<br>\r\n<img alt=\"\" src=\"http://image.wufazhuce.com/FrQrfYdlj7jIjJ1QOCxxpOIMDtDP?imageView2/2/w/394\" style=\"height:593px; width:394px\" /> <br>\r\n <br>\r\n这些男孩子们，精力都旺盛得很。平日再跋扈的，却也要作舍堂文化的螺丝钉。半夜里﹐听到敲门声。然后是怯怯的声音，央你喝一口他们煲的\u201c楼汤\u201d，你喝了一碗，便是欣喜得连声道谢，反让我不好意思。我是这层里唯一的研究生，是受礼遇的。不受约束的还有一个是非裔交流学者﹐据说来自剑桥。还保留着乡风﹐最喜裸着身体穿过走廊﹐走进洗澡间。边洗澡边大声地歌唱﹐唱的也是乡音乡调。浪里黑条﹐有哗哗的水声﹐若是和上非洲鼓﹐便是现场的民俗风情秀。听多了﹐便不再意外。后来他走了﹐整个楼层﹐便无可挽回地寂寥下来。<br>\r\n <br>\r\n再后来，也曾在东区的海滨小住。所以看到的海，多半是那里的。时常带了小狗去游水﹐它爱海水的程度﹐简直如同半尾鱼。<br>\r\n <br>\r\n黄昏时候，市区中心的海岸，看得见依岸而泊的小艇。艇上是各色刚刚捕捞上来的海鲜。海蜊、生蚝、象拔蚌和红杉鱼，都整整齐齐地搁在桶里。船娘卷起裤管站在船上，微笑地看着你，等着你挑拣。脸上是海水在余晖照耀下的光影。远处海天一色，交汇处有火红燃烧的云在流动，很美。<br>\r\n <br>\r\n大约有家的感觉的，还是现在的住处。和日常相关，每天下了班，回来了，便是这个地方，仿佛一个若有若无的盼头。然而去年的时候，叶老先生去世了，高寿九十二。隔壁的单位，便空了许久。过年的时候，搬进来两个年轻人，据说是先生的侄孙夫妇。面貌都很和气。男的戴着眼镜，斯文地笑。女的干练些，搬家的时候，似乎独当一面。二人形容勤勉简洁，是典型的香港人的样子。周末的清晨，隐约响起的是容祖儿和郑秀文的歌声。京胡和《法门寺》的唱段，是再也听不见了。<br>\r\n ","hp_makettime":"2010-02-03 19:20:00","hide_flag":"0","wb_name":"","wb_img_url":"","last_update_date":"2017-01-06 18:49:09","web_url":"http://m.wufazhuce.com/article/1701","guide_word":"景全是小景，因和日常相关，也更入眼入心。","audio":"","anchor":"","editor_email":"zhuxiaoying@wufazhuce.com","top_media_type":"0","top_media_file":"","top_media_image":"","start_video":"http://music.wufazhuce.com/lnuEMrktDTjm2lq4_s3k-FP9-6On","copyright":"本文经作者本人授权转载","author":[{"user_id":"7432465","user_name":"葛亮","desc":"最会说故事的小说家。《北鸢》《朱雀》热销中。","wb_name":"@葛亮。","is_settled":"0","settled_type":"0","summary":"最会说故事的小说家《北鸢》《朱雀》热销中","fans_total":"183","web_url":"http://image.wufazhuce.com/FnYU1C_xIe6c5LfF6SlXd6hFk41L"}],"maketime":"2010-02-03 19:20:00","author_list":[{"user_id":"7432465","user_name":"葛亮","desc":"最会说故事的小说家。《北鸢》《朱雀》热销中。","wb_name":"@葛亮。","is_settled":"0","settled_type":"0","summary":"最会说故事的小说家《北鸢》《朱雀》热销中","fans_total":"183","web_url":"http://image.wufazhuce.com/FnYU1C_xIe6c5LfF6SlXd6hFk41L"}],"next_id":"1714","previous_id":"1687","praisenum":86,"sharenum":5,"commentnum":13}
     */

    private int res;
    private DataBean data;

    public static NH_Essay objectFromData(String str) {

        return new Gson().fromJson(str, NH_Essay.class);
    }

    public static NH_Essay objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), NH_Essay.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NH_Essay> arrayNH_EassayFromData(String str) {

        Type listType = new TypeToken<ArrayList<NH_Essay>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<NH_Essay> arrayNH_EassayFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NH_Essay>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content_id : 1701
         * hp_title : 香港的铺子，好景常在
         * sub_title :
         * hp_author : 葛亮
         * auth_it : 最会说故事的小说家。《北鸢》《朱雀》热销中。
         * hp_author_introduce : 责任编辑：小影
         * hp_content : <br>
         <img alt="" src="http://image.wufazhuce.com/FqVrEbUC-uCvvw-p6xtUM-vgQH4Q?imageView2/2/w/394" style="height:262px; width:394px" /><br>
         <br>
         1.<br>
         现在住的地方，若用地产中介的口气﹐便说是“旺中带静”的。这街的形状﹐是一个长长的弧形﹐好像一枚新月。街道两边是一些有了年岁的楼宇。静的确是静的﹐其实闹市并不远。因为这街的形状﹐自成一统﹐便涤清了外界的许多声响。或许也是因为老旧﹐最初并不打算长居。因为家中曾经的变故﹐租住这里﹐是为了能在中午赶回家来﹐陪母亲吃饭。后来竟就住了下来﹐一住就是几年。<br>
         <br>
         一则是因为房东人实在是很好。房东叶老先生，是上海人。据说当年出租的时候，他有自己的挑剔。但因为听说我是南京来的，引为老乡，竟然很爽快地答应下来。叶先生是五十年代来港创业的工厂主，时当壮年，现在说广东话也还带了浓浓的乡音。当时香港的大环境和后来的经济起飞尚有距离。<br>
         <br>
         所以，艰苦的日子也是经过了的。第一次的置业，便是在这里买下了几个单位。自己住过红磡、湾仔。老了，就搬回了这里。大约也是好静，又见得到老街坊吧。叶先生喜烹饪﹐兴起，会烧一些地道的本帮菜，送过来与我分享。又喜欢京剧，有很多京戏的影碟。有时候听得见隔壁的声响，最多的是《法门寺》。<br>
         <br>
         这出我不陌生。大约因为外公也喜欢。有一次他还特来邀我和他一起听。是一出《空城计》。他说他其实最喜欢的，是马连良和周信芳。谈起来，竟也知道年轻得多的于魁智。便又感叹，他来香港的时候，于还未出生呢﹐现在居然就在大陆当红了。说完后﹐自己去了里屋翻了半天﹐翻出一把京胡，沾满了尘土。他一面擦灰，一面说这京胡跟他来了香港，也老了。原先弦是上好的马鬃，断了，在这里竟再也配不上。现在勉勉强强装上了钢丝，只有凑合地听了。说完就拉起一曲《大登殿》，声音有些尖利，但力道却是足的。在这咿咿呀呀里，窗外暮色也低沉下去。我便有些爱这条街了。<br>
         <br>
         <br>
         2.<br>
         回忆起来，在香港也迁居了多次。早前在港岛的西区﹐第一个住处，在山道上，四周的风物似乎是让人喜爱的。早上推开窗子，遥遥地能北望到海和浓重的晨雾。下了楼﹐看得见有许多弯折的小道。傍晚的时候，和缓的风也是山上来的。夕阳的光线从法国梧桐的叶子里筛下来，落到地上是星星点点。间或又吹下一两朵洋紫荆或者合欢，便是这光斑中的一两点锦簇。景全是小景，因和日常相关，也更入眼入心。<br>
         <br>
         这些小道，都不起眼，其实是西区的血脉，内在有严整的秩序。街边琳琅的小铺，都是因地制宜，见缝插针。名号却时常分外地大，比方说“贝多芬琴行” ﹑“刘海粟画院”﹐ 通常却不过十米见方﹐大约也是香港寸土寸金的明证。<br>
         <br>
         靠着正街，是很陡峭的一条街，从般咸道落下，站在上方，目光直上直下，可一直通向德辅道。整条街都是石板铺筑的阶梯，密集集地下落，几乎有点壮观的意思。这里是很多香港电影取景的地方。<br>
         <br>
         我常去的是靠近山脚下的一爿旧书店。叫做“平记”。终年是一盏泛了蓝的日光灯，瓦数很小，并且闪烁不定。倚墙摆了几个通天大书架，生铁或是木的，里面有很多漫画，因为有些是限量版，待价而沽。香港有数不清的漫画收藏迷，真的有肯为一本上世纪七十年代出版的《龙虎门》出上好几旧水的（香港白话称一百元为“一旧水”）。这个书店却专有一个中文书架，间歇让人有意想不到的收获。在这书架上，我淘到过天地初版钟晓阳的《流年》，联文版的《喜福会》，王瑶先生的《中国新文学史纲》，甚至有一本五十年代出版的丰子恺《绘画鲁迅小说》，品相十分的好。后来这间店，大约也关了门。<br>
         <br>
         山脚的德辅道是电车道。电车也算是香港的一道景致，一九〇四年开通迄今，竟有一百多年了，缓缓来往于港岛北的坚尼地城至筲箕湾，还在做着实际的用途。这车在香港人的口中又叫做“叮叮”，是它行动时的声响。响起来，大约就是张爱玲说的“市声”。可电车声在上海却是听不见了。这车是谈不上效率可言的，所以车上除了观光客，便是些师奶与孩童﹐一律都是怡然的神情。<br>
         <br>
         沿着海﹐“叮叮当当”地驶过上环，再进入中环、金钟。“中环速度”也便在这声音里不情不愿地慢下来了。搭乘这车，会闻见浓郁的海味，这是海产街上的气味，来自鱼翅﹑海参﹑花胶与其他干货。绕过梅芳街上了荷里活道，便有了另一番天地。<br>
         <br>
         这条道路Hollywood Road的起源，是因早年种植在路旁的冬青树名，又有一说holly其实是一种榕树。无论如何﹐也是早于美国“荷里活”的产生。曾经陪一个朋友、王家卫的粉丝﹐专程来这里朝拜《重庆森林》里梁朝伟的住处。只是行人电梯附近很普通的中式唐楼。朋友不免失望，说相见不如怀念。<br>
         <br>
         <img alt="" src="http://image.wufazhuce.com/FgXFbdxfO4me9Khn05sivVwDp_54?imageView2/2/w/394" style="height:591px; width:394px" /> <br>
         <br>
         这条街的声名，其实叫做古董街。错落着几十间极小的铺头。风格则一律清幽，又有烟火气，有点像南京的朝天宫，又整饬一些。没事的时候，我倒喜欢在这里逛一逛。东西多半是Chineseness，中国风，浓到化不开的。卷轴、陶瓷、漆器、都老旧得很。曾经看到一只紫檀木的明式小圈椅，手掌大小，细节入微，让人爱不忍释，价格亦甚为可观。倒是友人新婚，在这里买了两只葫芦，说是放在房间里作辟邪之用。葫芦上烙着一个人形，问起来，说是龙门派的王常月。这一派由丘处机所创，后来式微，到了王再复兴，已隔了几个世纪。若论避邪的功力，恐怕也减去几成了。<br>
         <br>
         年轻的也是有的，但依然是老调子。在这街道的拐角处，坐落着一间“住好啲”（G.O.D） 。本土设计师杨志超造出了生活的又一重海市蜃楼。老旧的印花布底裤﹐上世纪六十年代的铁皮水壶﹐发黄新闻纸图案的布艺躺椅﹐让人恍若隔世。却是二十一世纪新新人类的心头好。拐角里摆着本土的艺术杂志和《诚品好读》，每次去，总要翻上一翻。也就忍不住买上一两件东西，因为它们摆在那里恰如其分得如此悦目。但买回去，在自己的住处﹐却成了零余品。别看这表面灰厚的风格，却有着锋利的构思。这间家用品店被警方前后检控过两次，一次二〇〇四年时候推出 “Delay no more” 字样的产品，因为和粤语的粗口谐音，了众怒。一次是二〇〇七年，因为检获印有“拾肆K”字样的衬衣及明信片，涉嫌有关三合会社团14K，是成心要和社会不和谐。<br>
         <br>
         和谐的也是有的，到了中环皇后大道中，几间老字号，各据一方，各安其是。士丹利街的陆羽茶室，黑色的老吊扇，仍然缓慢地旋转。将时间转慢了，将香港人的心也转慢了。咬上一口蚧黄灌汤饺，喝上一口普洱，便不知归去。世人都说神仙好，惟有“莲香”忘不了。慕名来的，先都失望，都说破落。待吃上一口贵妃鸡，便都说来对了。来对了，便再要来，却见它越发破落了。再看威灵顿街上，“镛记”的排场是大的。朋友来香港，点名要吃这一家。例牌是烧鹅，好吃的却是顺德三宝，清水牛腩。<br>
         <br>
         这里靠德己立街已经很近了，窄窄的一条弯道，就进了兰桂坊。于我而言，这实在是个应景的地方，如果不是新年倒数，如果不是郁闷太甚，平日对汹涌的人潮避之不及。鬼佬、中产、猫三猫四、出出没没。倒是也有好地方。有一间极安静的酒吧叫Milk。或许也是生意不好，居然在热闹里渗出清冷来。一个面目严肃的菲律宾歌手唱着Love me tender。歌声也很清冷。<br>
         <br>
         3.<br>
         后来，终于从山道上搬了，搬进了规整的校园区。忙于研究与论文，这些地方便也很少去。去得少了，心思便也淡了。后来就像是没了瘾。先是在研究生堂住，前见海，后见山，是极其好的清静地。<br>
         <br>
         在这里﹐我开始写我的长篇小说《朱雀》，也是恰逢其时。此后搬到叫做STARR的校舍。楼层住得很高，也面海，竟可以看到驻港部队的空军演习。对面是何东夫人堂，男学生经常情不自禁地望过去，是间女生舍堂。我看到时，早已翻了新。旧时的格局是可笑的贵族风，房内两张床，一张是女学生的，一张是给随行的女佣。后来终究要拆，拆之前也依恋。张婉婷便说，那好，我来拍一出戏。便是《玻璃之城》。都说舒淇将港大女生演绎得惟妙惟肖。败笔是黎明，港大的男孩子，可没有这样老实头的。<br>
         <br>
         <img alt="" src="http://image.wufazhuce.com/FrQrfYdlj7jIjJ1QOCxxpOIMDtDP?imageView2/2/w/394" style="height:593px; width:394px" /> <br>
         <br>
         这些男孩子们，精力都旺盛得很。平日再跋扈的，却也要作舍堂文化的螺丝钉。半夜里﹐听到敲门声。然后是怯怯的声音，央你喝一口他们煲的“楼汤”，你喝了一碗，便是欣喜得连声道谢，反让我不好意思。我是这层里唯一的研究生，是受礼遇的。不受约束的还有一个是非裔交流学者﹐据说来自剑桥。还保留着乡风﹐最喜裸着身体穿过走廊﹐走进洗澡间。边洗澡边大声地歌唱﹐唱的也是乡音乡调。浪里黑条﹐有哗哗的水声﹐若是和上非洲鼓﹐便是现场的民俗风情秀。听多了﹐便不再意外。后来他走了﹐整个楼层﹐便无可挽回地寂寥下来。<br>
         <br>
         再后来，也曾在东区的海滨小住。所以看到的海，多半是那里的。时常带了小狗去游水﹐它爱海水的程度﹐简直如同半尾鱼。<br>
         <br>
         黄昏时候，市区中心的海岸，看得见依岸而泊的小艇。艇上是各色刚刚捕捞上来的海鲜。海蜊、生蚝、象拔蚌和红杉鱼，都整整齐齐地搁在桶里。船娘卷起裤管站在船上，微笑地看着你，等着你挑拣。脸上是海水在余晖照耀下的光影。远处海天一色，交汇处有火红燃烧的云在流动，很美。<br>
         <br>
         大约有家的感觉的，还是现在的住处。和日常相关，每天下了班，回来了，便是这个地方，仿佛一个若有若无的盼头。然而去年的时候，叶老先生去世了，高寿九十二。隔壁的单位，便空了许久。过年的时候，搬进来两个年轻人，据说是先生的侄孙夫妇。面貌都很和气。男的戴着眼镜，斯文地笑。女的干练些，搬家的时候，似乎独当一面。二人形容勤勉简洁，是典型的香港人的样子。周末的清晨，隐约响起的是容祖儿和郑秀文的歌声。京胡和《法门寺》的唱段，是再也听不见了。<br>

         * hp_makettime : 2010-02-03 19:20:00
         * hide_flag : 0
         * wb_name :
         * wb_img_url :
         * last_update_date : 2017-01-06 18:49:09
         * web_url : http://m.wufazhuce.com/article/1701
         * guide_word : 景全是小景，因和日常相关，也更入眼入心。
         * audio :
         * anchor :
         * editor_email : zhuxiaoying@wufazhuce.com
         * top_media_type : 0
         * top_media_file :
         * top_media_image :
         * start_video : http://music.wufazhuce.com/lnuEMrktDTjm2lq4_s3k-FP9-6On
         * copyright : 本文经作者本人授权转载
         * author : [{"user_id":"7432465","user_name":"葛亮","desc":"最会说故事的小说家。《北鸢》《朱雀》热销中。","wb_name":"@葛亮。","is_settled":"0","settled_type":"0","summary":"最会说故事的小说家《北鸢》《朱雀》热销中","fans_total":"183","web_url":"http://image.wufazhuce.com/FnYU1C_xIe6c5LfF6SlXd6hFk41L"}]
         * maketime : 2010-02-03 19:20:00
         * author_list : [{"user_id":"7432465","user_name":"葛亮","desc":"最会说故事的小说家。《北鸢》《朱雀》热销中。","wb_name":"@葛亮。","is_settled":"0","settled_type":"0","summary":"最会说故事的小说家《北鸢》《朱雀》热销中","fans_total":"183","web_url":"http://image.wufazhuce.com/FnYU1C_xIe6c5LfF6SlXd6hFk41L"}]
         * next_id : 1714
         * previous_id : 1687
         * praisenum : 86
         * sharenum : 5
         * commentnum : 13
         */

        private String content_id;
        private String hp_title;
        private String sub_title;
        private String hp_author;
        private String auth_it;
        private String hp_author_introduce;
        private String hp_content;
        private String hp_makettime;
        private String hide_flag;
        private String wb_name;
        private String wb_img_url;
        private String last_update_date;
        private String web_url;
        private String guide_word;
        private String audio;
        private String anchor;
        private String editor_email;
        private String top_media_type;
        private String top_media_file;
        private String top_media_image;
        private String start_video;
        private String copyright;
        private String maketime;
        private String next_id;
        private String previous_id;
        private int praisenum;
        private int sharenum;
        private int commentnum;
        private List<AuthorBean> author;
        private List<AuthorListBean> author_list;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getHp_title() {
            return hp_title;
        }

        public void setHp_title(String hp_title) {
            this.hp_title = hp_title;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public String getHp_author() {
            return hp_author;
        }

        public void setHp_author(String hp_author) {
            this.hp_author = hp_author;
        }

        public String getAuth_it() {
            return auth_it;
        }

        public void setAuth_it(String auth_it) {
            this.auth_it = auth_it;
        }

        public String getHp_author_introduce() {
            return hp_author_introduce;
        }

        public void setHp_author_introduce(String hp_author_introduce) {
            this.hp_author_introduce = hp_author_introduce;
        }

        public String getHp_content() {
            return hp_content;
        }

        public void setHp_content(String hp_content) {
            this.hp_content = hp_content;
        }

        public String getHp_makettime() {
            return hp_makettime;
        }

        public void setHp_makettime(String hp_makettime) {
            this.hp_makettime = hp_makettime;
        }

        public String getHide_flag() {
            return hide_flag;
        }

        public void setHide_flag(String hide_flag) {
            this.hide_flag = hide_flag;
        }

        public String getWb_name() {
            return wb_name;
        }

        public void setWb_name(String wb_name) {
            this.wb_name = wb_name;
        }

        public String getWb_img_url() {
            return wb_img_url;
        }

        public void setWb_img_url(String wb_img_url) {
            this.wb_img_url = wb_img_url;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getGuide_word() {
            return guide_word;
        }

        public void setGuide_word(String guide_word) {
            this.guide_word = guide_word;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }

        public String getAnchor() {
            return anchor;
        }

        public void setAnchor(String anchor) {
            this.anchor = anchor;
        }

        public String getEditor_email() {
            return editor_email;
        }

        public void setEditor_email(String editor_email) {
            this.editor_email = editor_email;
        }

        public String getTop_media_type() {
            return top_media_type;
        }

        public void setTop_media_type(String top_media_type) {
            this.top_media_type = top_media_type;
        }

        public String getTop_media_file() {
            return top_media_file;
        }

        public void setTop_media_file(String top_media_file) {
            this.top_media_file = top_media_file;
        }

        public String getTop_media_image() {
            return top_media_image;
        }

        public void setTop_media_image(String top_media_image) {
            this.top_media_image = top_media_image;
        }

        public String getStart_video() {
            return start_video;
        }

        public void setStart_video(String start_video) {
            this.start_video = start_video;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getMaketime() {
            return maketime;
        }

        public void setMaketime(String maketime) {
            this.maketime = maketime;
        }

        public String getNext_id() {
            return next_id;
        }

        public void setNext_id(String next_id) {
            this.next_id = next_id;
        }

        public String getPrevious_id() {
            return previous_id;
        }

        public void setPrevious_id(String previous_id) {
            this.previous_id = previous_id;
        }

        public int getPraisenum() {
            return praisenum;
        }

        public void setPraisenum(int praisenum) {
            this.praisenum = praisenum;
        }

        public int getSharenum() {
            return sharenum;
        }

        public void setSharenum(int sharenum) {
            this.sharenum = sharenum;
        }

        public int getCommentnum() {
            return commentnum;
        }

        public void setCommentnum(int commentnum) {
            this.commentnum = commentnum;
        }

        public List<AuthorBean> getAuthor() {
            return author;
        }

        public void setAuthor(List<AuthorBean> author) {
            this.author = author;
        }

        public List<AuthorListBean> getAuthor_list() {
            return author_list;
        }

        public void setAuthor_list(List<AuthorListBean> author_list) {
            this.author_list = author_list;
        }

        public static class AuthorBean {
            /**
             * user_id : 7432465
             * user_name : 葛亮
             * desc : 最会说故事的小说家。《北鸢》《朱雀》热销中。
             * wb_name : @葛亮。
             * is_settled : 0
             * settled_type : 0
             * summary : 最会说故事的小说家《北鸢》《朱雀》热销中
             * fans_total : 183
             * web_url : http://image.wufazhuce.com/FnYU1C_xIe6c5LfF6SlXd6hFk41L
             */

            private String user_id;
            private String user_name;
            private String desc;
            private String wb_name;
            private String is_settled;
            private String settled_type;
            private String summary;
            private String fans_total;
            private String web_url;

            public static AuthorBean objectFromData(String str) {

                return new Gson().fromJson(str, AuthorBean.class);
            }

            public static AuthorBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), AuthorBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<AuthorBean> arrayAuthorBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<AuthorBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<AuthorBean> arrayAuthorBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<AuthorBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getWb_name() {
                return wb_name;
            }

            public void setWb_name(String wb_name) {
                this.wb_name = wb_name;
            }

            public String getIs_settled() {
                return is_settled;
            }

            public void setIs_settled(String is_settled) {
                this.is_settled = is_settled;
            }

            public String getSettled_type() {
                return settled_type;
            }

            public void setSettled_type(String settled_type) {
                this.settled_type = settled_type;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getFans_total() {
                return fans_total;
            }

            public void setFans_total(String fans_total) {
                this.fans_total = fans_total;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }
        }

        public static class AuthorListBean {
            /**
             * user_id : 7432465
             * user_name : 葛亮
             * desc : 最会说故事的小说家。《北鸢》《朱雀》热销中。
             * wb_name : @葛亮。
             * is_settled : 0
             * settled_type : 0
             * summary : 最会说故事的小说家《北鸢》《朱雀》热销中
             * fans_total : 183
             * web_url : http://image.wufazhuce.com/FnYU1C_xIe6c5LfF6SlXd6hFk41L
             */

            private String user_id;
            private String user_name;
            private String desc;
            private String wb_name;
            private String is_settled;
            private String settled_type;
            private String summary;
            private String fans_total;
            private String web_url;

            public static AuthorListBean objectFromData(String str) {

                return new Gson().fromJson(str, AuthorListBean.class);
            }

            public static AuthorListBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), AuthorListBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<AuthorListBean> arrayAuthorListBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<AuthorListBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<AuthorListBean> arrayAuthorListBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<AuthorListBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getWb_name() {
                return wb_name;
            }

            public void setWb_name(String wb_name) {
                this.wb_name = wb_name;
            }

            public String getIs_settled() {
                return is_settled;
            }

            public void setIs_settled(String is_settled) {
                this.is_settled = is_settled;
            }

            public String getSettled_type() {
                return settled_type;
            }

            public void setSettled_type(String settled_type) {
                this.settled_type = settled_type;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getFans_total() {
                return fans_total;
            }

            public void setFans_total(String fans_total) {
                this.fans_total = fans_total;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }
        }
    }
}
