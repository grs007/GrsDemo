package com.grs.my.net;


import com.grs.my.bean.HttpResult;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by snail on 16/11/8.
 */
public interface IMyApi {
//    /**
//     * 登录接口
//     *
//     * @param phone  手机号（帐号）
//     * @param passwd 密码
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/loginapi/login")
//    Observable<Response<HttpResult<SignIn>>> login(@Field("phone") String phone, @Field("passwd") String passwd);
//
//    /**
//     * 注册1
//     *
//     * @param phone 手机号
//     * @param auth  验证码
//     * @param pwd   密码
//     * @param role  角色 1 学生 2 家长
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/loginapi/register_stepone")
//    Observable<HttpResult<Regist1>> register1(@Field("phone") String phone, @Field("check_code") String auth,
//                                              @Field("passwd") String pwd, @Field("roletype") String role);
//
//    /**
//     * 获取验证码
//     *
//     * @param phone 手机号
//     * @param type  1 注册 2 忘记密码 3 修改密码
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/loginapi/send_message")
//    Observable<HttpResult> getVerificationCode(@Field("phone") String phone, @Field("type") String type);
//
//    /**
//     * 注册2
//     *
//     * @param realname   学生姓名
//     * @param teachernum 老师号
//     * @param sex        性别 1 男 2 女
//     * @param u_id       用户id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/loginapi/register_steptwo")
//    Observable<HttpResult<TeacherClass>> register2(@Field("realname") String realname
//            , @Field("teachernum") String teachernum
//            , @Field("sex") String sex
//            , @Field("u_id") String u_id);
//
//    /**
//     * 加入班级  注册3
//     *
//     * @param u_id  用户id
//     * @param tg_id 班级 id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/loginapi/register_stepthree")
//    Observable<HttpResult> register3(@Field("u_id") String u_id, @Field("tg_id") String tg_id);
//
//    /**
//     * 加入教材 注册3
//     *
//     * @param u_id    用户id
//     * @param m_class 年级
//     * @param m_type  学期 1上学期 2下学期
//     * @param m_eid   版本id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/loginapi/register_stepthree_")
//    Observable<HttpResult> register3_(@Field("u_id") String u_id, @Field("m_class") String m_class,
//                                      @Field("m_type") String m_type, @Field("m_eid") String m_eid);
//
//
    /**
     * 获取教材列表
     *
     * @return
     */
    @GET("/api/materials/geteditions")
    Observable<HttpResult> getEditions();
//
//    /**
//     * 忘记密码
//     *
//     * @param phone 手机号
//     * @param pwd   新密码
//     * @param auth  验证码
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/loginapi/forget_pwd")
//    Observable<HttpResult> forget(@Field("phone") String phone, @Field("new_pwd") String pwd, @Field("check_code") String auth);
//
//    /**
//     * 获取用户当前教材信息
//     *
//     * @return
//     */
//    @GET("/api/materials/getunitlist")
//    Observable<HttpResult<Unitlist>> getUnitlist();
//
//    /**
//     * 更换教材
//     *
//     * @param type  学期 1上 2下
//     * @param grade 年级
//     * @param m_eid 版本id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/materials/changematerials_")
//    Observable<HttpResult> changeBook(@Field("m_type") String type, @Field("m_class") String grade, @Field("m_eid") String m_eid);
//
//    /**
//     * 获取同步语文首页
//     *
//     * @return
//     */
//    @GET("/api/index/index")
//    Observable<HttpResult<HomeChinese>> getHomeChinese();
//
//    /**
//     * 获取讲解首页
//     *
//     * @param se_id 课节id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/materials/getmodbysection")
//    Observable<HttpResult<List<Explain>>> getmodbysection(@Field("c_seid") String se_id);
//
//    /**
//     * 获取课文段意
//     *
//     * @param se_id
//     * @return
//     */
//    @GET("/api/materials/getkewen")
//    Observable<HttpResult<BookText>> getKewen(@Query("se_id") String se_id);
//
//    /**
//     * 获取文本类模块内容
//     *
//     * @param c_id 模块id
//     * @return
//     */
//    @GET("/api/materials/gettext")
//    Observable<HttpResult<WritText>> getText(@Query("c_id") String c_id);
//
//    /**
//     * 获取播放信息
//     *
//     * @param vid 视频
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/materials/getvideo")
//    Observable<HttpResult<PlayVideo>> getVideo(@Field("vid") String vid);
//
//    /**
//     * 获取播放信息
//     *
//     * @param vid 视频
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/getVideo")
//    Observable<HttpResult<PlayVideo>> getVideoUrl(@Field("vid") String vid);
//
//    /**
//     * 获取作业本播放信息
//     *
//     * @param vid 视频
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/getQrVideo")
//    Observable<HttpResult<PlayVideo>> getWorkVideoUrl(@Field("qrid") String vid);
//
//    /**
//     * 获取生字列表
//     *
//     * @param re_id 课节id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/materials/getworldsbyseid")
//    Observable<HttpResult<WordsModel>> getNewWords(@Field("r_seid") String re_id);
//
//    /**
//     * 获取学生作业状态
//     *
//     * @param cookie
//     * @return
//     */
//    @POST("/api/hmwk/getuserhwstate")
//    Observable<HttpResult<HomeWorkState>> getHomeWorkState(@Header("Cookie") String cookie);
//
//    /**
//     * 提交同步作业
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/hmwk/putuserhomewk")
//    Observable<HttpResult<List<HomeWork.RankinfoBean>>> commitHomework(@Field("hwid") int hwid,
//                                                                       @Field("status") String status, @Field("seconds") String secondes,
//                                                                       @Field("rpercent") int rpercent, @Field("rnum") int rnum,
//                                                                       @Field("total") int total, @Field("answer") String answer, @Field("lastqnum") String lastqnum);
//
//    /**
//     * 提交同步测试
//     *
//     * @param us_seid   课程ID
//     * @param us_time   用户做题时长
//     * @param us_answer 用户答案
//     * @param us_status 用户是否做完 1 未做完 2 做完
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/testsave")
//    Observable<HttpResult<String>> commitTest(@Field("us_seid") String us_seid,
//                                              @Field("us_time") String us_time,
//                                              @Field("us_answer") String us_answer,
//                                              @Field("us_status") String us_status,
//                                              @Field("lastqnum") String lastqnum);
//
//    /**
//     * 学生同步测试排行
//     *
//     * @param uid  学生ID
//     * @param seid 作业ID或者课节ID
//     * @param type Test同步排行 homework家庭作业排行
//     * @return
//     */
//    @Deprecated
//    @FormUrlEncoded
//    @POST("/api/test/testsort")
//    Observable<HttpResult<Rank>> getTestRankList(@Field("uid") int uid, @Field("seid") int seid, @Field("type") String type);
//
//    /**
//     * 获取同步测试目录
//     *
//     * @return
//     */
//    @POST("/api/test/index")
//    Observable<HttpResult<TestCataGory>> getTestCatagory();
//
//    /**
//     * 同步测试测试题
//     *
//     * @param type  测试题类型 test同步测试 homework家庭作业
//     * @param se_id 课程ID
//     * @return
//     */
//    @Deprecated
//    @FormUrlEncoded
//    @POST("/api/test/testquestion")
//    Observable<HttpResult<TestQuestion>> getTQuestion(@Field("type") String type, @Field("se_id") int se_id);
//
//    /**
//     * 同步测试测试题
//     *
//     * @param se_id 课程ID
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/tquestion")
//    Observable<HttpResult<TestQuestion>> getTestQuestion(@Field("se_id") int se_id);
//
//    /**
//     * 同步作业题目
//     *
//     * @param seid 课程ID
//     * @return
//     */
//    @GET("/api/hmwk/getuserwork")
//    Observable<HttpResult<HomeWork>> getHomeWork(@Query("seid") int seid);
//
//    /**
//     * 同步测试 错题集查看
//     *
//     * @param wr_id 错题集ID
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/wrongquestion")
//    Observable<HttpResult<TestQuestion>> getTestErrorList(@Field("wr_id") String wr_id);
//
//    /**
//     * 同步测试错题集重做  根据题id获取指定的错题集合
//     *
//     * @param wr_id 错题集ID
//     * @param wr_id 题ID 可多可单
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/wrongremake")
//    Observable<HttpResult<TestQuestion>> getTestError(@Field("wr_id") String wr_id, @Field("qs_id") String qs_id);
//
//    /**
//     * 获取作业列表
//     *
//     * @param qtype all,finished,unfinished,nobegain 所有数据，已完成部分，未完成部分,未开始的
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/hmwk/showlist")
//    Observable<HttpResult<HomeWorkRecord>> getHomeworkList(@Field("qtype") String qtype);
//
//    /**
//     * 获取作业列表(新 17-7-7开始使用)
//     *
//     * @param page
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/nhw/hwlist")
//    Observable<HttpResult<List<HomeWorkNew>>> getHomeworkNewLists(@Field("page") int page, @Field("month") String month);
//
//    /**
//     * 作业详情
//     *
//     * @param thid
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/nhw/hwdata")
//    Observable<HttpResult<DoHomeWork>> getHomeWorkInfo(@Field("thid") String thid);
//
//    /**
//     * 保存作业
//     *
//     * @param isdone   1未完成 2已经完成
//     * @param qnum     完成时提交：总题数 只统计大题数量
//     * @param rnum     完成时提交：正确题数
//     * @param answer   答案
//     * @param thid     作业id
//     * @param rpercent 完成时提交：正确率 只统计大题正确率
//     * @param imgurl   线下交作业是作业图片，线上可以不填
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/nhw/saveHw")
//    Observable<HttpResult> commitHomeWork(@Field("isdone") String isdone, @Field("qnum") String qnum, @Field("rnum") String rnum, @Field("answer") String answer, @Field("thid") String thid, @Field("rpercent") String rpercent, @Field("imgurl") String imgurl, @Field("page") int page);
//
//    /**
//     * 获取作业结果页
//     *
//     * @param thid
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/nhw/hwsort")
//    Observable<HttpResult<WorkResult>> getWorkResult(@Field("thid") String thid);
//
//    /**
//     * 获取作业错题
//     *
//     * @param thid
//     * @param type 1错误解析  2全部解析
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/nhw/qlist")
//    Observable<HttpResult<WrongWork>> getWrongWork(@Field("thid") String thid, @Field("type") String type);
//
//    /**
//     * 线下获取作业详情
//     *
//     * @return
//     */
//    @GET("/api/nhw/qrsavehw")
//    Observable<HttpResult<PhotoWork>> getWorkInfoUnLine();
//
//    /**
//     * 获取错题集
//     *
//     * @return
//     */
//    @POST("/api/test/wrongdir")
//    Observable<HttpResult<TestErrorRecord>> getErrorList();
//
//    /**
//     * 同步测试 清除错题
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/delwrong")
//    Observable<HttpResult<String>> clearError(@Field("wrid") int wrid, @Field("qid") String qid);
//
//    /**
//     * 获取我的页面数据(包含个人信息)
//     *
//     * @return
//     */
//    @GET("/api/center/getMyMation")
//    Observable<HttpResult<HomeMy>> getHomeMy();
//
//    /**
//     * 获取订单信息
//     *
//     * @return
//     */
//    @GET("/pay/topay")
//    Observable<HttpResult<PayOrder>> getOrder(@Query("validdates") int validdates, @Query("payfr") String payfr, @Query("price") String price);
//
//    /**
//     * 获取购买月份类型信息
//     *
//     * @return
//     */
//    @GET("/api/hmwk/getpriceinfo")
//    Observable<HttpResult<List<PayType>>> getPrice();
//
//    /**
//     * 验证订单是否支付成功
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/pay/checktrade")
//    Observable<HttpResult<String>> checkOrder(@Field("trade_no") String trade_no);
//
//    /**
//     * 获取教材版本
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/textbookedition")
//    Observable<HttpResult<List<BookEdition>>> getBookEdition(@Field("m_classname") String m_classname, @Field("m_typename") String m_typename);
//
//    /**
//     * 设置教材版本
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/settextbook")
//    Observable<HttpResult<List<BookEdition>>> setTextBook(@Field("m_id") String m_id);
//
//
//    /**
//     * 上传图片
//     *
//     * @param file
//     * @return
//     */
//    @Multipart
//    @POST("/api/upload/uploadImg")
//    Observable<HttpResult<ImageBean>> uploadimg(@Part("file_type") RequestBody file_type, @Part("upfile\"; filename=\"tongbuxue.jpg\"") RequestBody file);
//
//    /**
//     * 更新头像
//     *
//     * @param img
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/updateUser")
//    Observable<HttpResult> updateImg(@Field("u_headerimg") String img);
//
//    /**
//     * 修改手机号
//     *
//     * @param newphone 新手机号
//     * @param auth     验证码
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/updatePhone")
//    Observable<HttpResult<ChangePhone>> updatePhone1(@Field("new_phone") String newphone, @Field("send_num_") String auth);
//
//    /**
//     * 修改手机号
//     *
//     * @param newphone 新手机号
//     * @param auth     验证码
//     * @param skip     是否跳过检查有无老师账号	0不跳过	1跳过（用于多账号用户）
//     * @param yes      是否同时修改老师用户的手机号	0不修改	1同时修改（用于多账号用户）
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/updatePhone")
//    Observable<HttpResult<ChangePhone>> updatePhone2(@Field("new_phone") String newphone, @Field("send_num_") String auth, @Field("skip") String skip, @Field("yes") String yes);
//
//    /**
//     * 获取老师信息
//     *
//     * @param teachernum 老师号
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/UpdateTeacher")
//    Observable<HttpResult<TeacherInfo>> updateTeacher(@Field("teach_num") String teachernum);
//
//    /**
//     * 更换老师
//     *
//     * @param tc_id
//     * @param class_id
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/sendApply")
//    Observable<HttpResult> changeTeacher(@Field("tc_id") String tc_id, @Field("class_id") String class_id);
//
//    /**
//     * 我的班级
//     *
//     * @return
//     */
//    @GET("/api/center/myClass")
//    Observable<HttpResult<MyClass>> getMyClass();
//
//    /**
//     * 修改密码
//     *
//     * @param newPwd 新密码
//     * @param auth   验证码
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/updatePwd")
//    Observable<HttpResult> changePwd(@Field("new_pwd") String newPwd, @Field("send_num") String auth);
//
//    /**
//     * 获取课表
//     *
//     * @return 一周课表
//     */
//    @GET("/api/center/myKebiao")
//    Observable<HttpResult<MySyllabus>> getSyllabus();
//
//    /**
//     * 通讯录
//     *
//     * @return
//     */
//    @GET("/api/center/getAddress")
//    Observable<HttpResult<MyAddress>> getAddresses();
//
//    /**
//     * 获取通讯录详情
//     *
//     * @param u_id 用户id
//     * @param type 1学生 2老师
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/getAddresInfo")
//    Observable<HttpResult<AddresInfoS>> getAddresInfoS(@Field("userid") String u_id, @Field("usertype") String type);
//
//    /**
//     * 获取通讯录详情
//     *
//     * @param u_id 用户id
//     * @param type 1学生 2老师
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/getAddresInfo")
//    Observable<HttpResult<AddresInfoT>> getAddresInfoT(@Field("userid") String u_id, @Field("usertype") String type);
//
//    /**
//     * 我的等级
//     *
//     * @return
//     */
//    @GET("/api/center/myLevel")
//    Observable<HttpResult<MyLevel>> getMyLevel();
//
//    /**
//     * 学习轨迹
//     *
//     * @return
//     */
//    @GET("/api/center/myTrajectory")
//    Observable<HttpResult<MyLocus>> getMyLocus();
//
//    /**
//     * 我的成绩
//     *
//     * @param page
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/myScore")
//    Observable<HttpResult<MyPerformance>> getMyPerformance(@Field("page") int page);
//
//    /**
//     * 我的成绩
//     * <p>
//     * 17.07.14 开始使用
//     *
//     * @param page
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/myScore_new")
//    Observable<HttpResult<MyPerformanceNew>> getMyPerformancenew(@Field("page") int page);
//
//    /**
//     * 获取打卡记录
//     *
//     * @return
//     */
//    @GET("/api/center/myClock")
//    Observable<HttpResult<MyPunch>> getMyPunch();
//
//    /**
//     * 我的消息
//     *
//     * @param page   页码
//     * @param type   1系统 2老师
//     * @param isread 1未读 2已读
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/myMessage")
//    Observable<HttpResult<List<MyMessage>>> getMyMessage(@Field("p") String page, @Field("type") String type, @Field("isread") String isread);
//
//    /**
//     * 标记全部已读
//     *
//     * @param type 1 系统消息 2私人消息
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/readAll")
//    Observable<HttpResult> readAll(@Field("type") String type);
//
//    /**
//     * 获取消息详情
//     *
//     * @param msid
//     * @param type 1系统 2私人（老师）
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/readMessage")
//    Observable<HttpResult<MessageInfo>> getMsg(@Field("msid") String msid, @Field("type") String type);
//
//    /**
//     * 删除 私人（老师）消息
//     *
//     * @param msid   消息id 若要删除全部 此字段可不填写
//     * @param delall 是否删除全部 0否（默认）1是 若为0，此字段可不填写
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/delSelfMes")
//    Observable<HttpResult> delSelfMsg(@Field("msid") String msid, @Field("delall") String delall);
//
//    /**
//     * 删除 系统消息
//     *
//     * @param msid   消息id 若要删除全部 此字段可不填写
//     * @param delall 是否删除全部 0否（默认）1是 若为0，此字段可不填写
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/delSysmes")
//    Observable<HttpResult> delSysMsg(@Field("msid") String msid, @Field("delall") String delall);
//
//    /**
//     * 是否有新消息
//     *
//     * @return 1有 0无
//     */
//    @GET("/api/index/hasNewsMes")
//    Observable<HttpResult<HasMsg>> hasMsg();
//
//    /**
//     * 修改生日
//     *
//     * @param u_birthtime 时间戳(秒)
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/updateBirthday")
//    Observable<HttpResult> updateBirthtime(@Field("u_birthtime") String u_birthtime);
//
//    /**
//     * 个人介绍
//     *
//     * @param desc
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/center/updateDesc")
//    Observable<HttpResult> updateDesc(@Field("u_desc") String desc);
//
//    /**
//     * 签到
//     *
//     * @return
//     */
//    @GET("/api/center/explevel")
//    Observable<HttpResult<Explevel>> explevel();
//
//    /**
//     * 获取教材详情
//     *
//     * @return
//     */
//    @GET("/api/materials/getMaterialInfo")
//    Observable<HttpResult<BookInfo>> getBookInfo();
//
//    /**
//     * app版本检查更新
//     *
//     * @return
//     */
//    @GET("/api/Upgrade/checkupdate")
//    Observable<HttpResult<Version>> checkVersion();
//
//    /**
//     * 获取新的测试题和排行榜
//     *
//     * @param se_id 课程ID
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/newQuestion")
//    Observable<HttpResult<TestQuestion>> getNewTestQuestion(@Field("se_id") int se_id);
//
//    /**
//     * 同步测试 错题集查看
//     *
//     * @param wr_id 错题集ID
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/newWrongQuestion")
//    Observable<HttpResult<TestQuestion>> getNewTestErrorList(@Field("wr_id") String wr_id);
//
//    /**
//     * 同步测试错题集重做  根据题id获取指定的错题集合
//     *
//     * @param wr_id 错题集ID
//     * @param wr_id 题ID 可多可单
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/api/test/newWrongRemake")
//    Observable<HttpResult<TestQuestion>> getNewTestError(@Field("wr_id") String wr_id, @Field("qs_id") String qs_id);
//
//    /**
//     * 免费观看视频5次
//     *
//     * @return
//     */
//    @GET("/api/test/cVideoNum")
//    Observable<HttpResult> hasTryLook();
}