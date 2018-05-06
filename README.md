# Weather
`一款看起来像天气应用的应用`
##### 应用截图
|  天气主页  |  one主页  |  音乐资讯主页  |
| --- | --- | --- |
|  <img src="https://github.com/985211yygg/Weather1/blob/master/screenShots/1.png?raw=true"  width="200"  >   |  <img src="https://github.com/985211yygg/Weather1/blob/master/screenShots/2.png?raw=true"  width="200"  >   |   <img src="https://github.com/985211yygg/Weather1/blob/master/screenShots/3.png?raw=true"  width="200"  >  |

| 资讯详情 | 主题颜色切换 | 图片浏览、仿头条滑动返回 |
| -------- | ------- | ------------ |
|    <img src="https://github.com/985211yygg/Weather1/blob/master/screenShots/4.png?raw=true"  width="200"  >      |  <img src="https://github.com/985211yygg/Weather1/blob/master/screenShots/5.png?raw=true"  width="200"  >       |     <img src="https://github.com/985211yygg/Weather1/blob/master/screenShots/11.gif?raw=true"  width="200"  >    |

| 视频播放   |  视频播放  |    |
| --- | --- | --- |
|  <img src="https://github.com/985211yygg/Weather1/blob/master/screenShots/22.gif?raw=true" width="200" >   |   <img src="https://github.com/985211yygg/Weather1/blob/master/screenShots/33.gif?raw=true" width="200" >  |     |



##### 应用简介
weather一款综合的资讯类应用，集天气，图片，音乐，影视资讯，视频播放为一体。
- 天气部分，展示本地天气详情，**支持语音播报**，多种形式分享天气情况；

- 内涵部分，综合了阅读、音乐。影视资讯等讯息，内容丰富，**并实现了仿简书长按详情页以图片方式分享内容**；

- 虎嗅部分，爬取了妹子图微信公众号网页信息，展示各种福利图片，**重点实现了webview与JS的交互，包括图片点击，长按，网页中所有图片获取并展示**。

- 开眼部分 ，主要利用了开眼视频的开放API,实现了各种类型短视频的浏览，搜索功能尚未实现

- 设置部分 ，主要实现了**多种主题颜色的切换**

应用还存在未知或已知的bug,正在完善改正。
已知未能解决bug：仿简书长图分享文章偶尔OOM；基于开源播放器GSYVideoPlaye视频播放部分，加载视频偶尔出现错误
##### 使用的主要开源库
- Okhttp 和Retrofit  网络请求

- RxJava   响应式函数编程框架

- Eventbus       事件订阅通知

- RxPermissions   权限请求库

- BaseRecyclerViewAdapterHelper  通用的RecyclerViewAdapte

- Glide  图片加载库

- PhotoView  可缩放，拖动的ImageView库

- GSYVideoPlayer  开源播放器库

- 集成德高地图定位SDK

- Utilcode 常用工具类库

- Material-Dialogs  材料设计对话框库
