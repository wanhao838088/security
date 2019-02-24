/*
包含n个接口请求函数的模块
函数的返回值: promise对象
 */
import ajax from './ajax'

const BASE_URL = 'http://cangdu.org:8001';

//自有项目api
const MY_URL = 'http://localhost:8081/renren-api/api';

// 1、手机号密码登陆
export const reqPwdLogin = ({name, password}) =>
  ajax(MY_URL+`/login`,{mobile:name, password},"POST");

// 2、发送短信验证码
export const reqSendCode = ({mobile,deviceId}) =>
  ajax(MY_URL+'/getCode', {mobile,deviceId},"POST");


// 8、手机号验证码登陆
export const reqSmsLogin = (phone, code) =>
  ajax(MY_URL+'/userController/loginByPhone', {phone, code});


// 9、根据会话获取用户信息
export const reqUserInfo = () => ajax(MY_URL+'/userController/reqUserInfo');
// 10、用户登出
export const reqLogout = () => ajax(MY_URL+'/userController/logout');

