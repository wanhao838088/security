/**
 * 生成uuid
 * @returns {string}
 */
export function generateUUID() {
  var d = new Date().getTime();
  if (window.performance && typeof window.performance.now === "function") {
    d += performance.now(); //use high-precision timer if available
  }
  var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
    var r = (d + Math.random() * 16) % 16 | 0;
    d = Math.floor(d / 16);
    return (c == 'x' ? r : (r & 0x3 | 0x8)).toString(16);
  });
  return uuid;
}


/**
 * 在本地存储一个键值对
 * @param key
 * @param value
 */
export function setAttr(key, value) {
  if(key){
    window.localStorage.setItem(key,value);
  }
}

/**
 * 查询键值对
 * @param key
 * @param value
 */
export function getAttr(key) {
  if(key){
    return window.localStorage.getItem(key);
  }
}

/**
 * 设置设备id
 * @param value
 */
export function setDeviceId(value) {
  window.localStorage.setItem("deviceId",value);
}

/**
 * 获取设备id
 * @returns {string}
 */
export function getDeviceId() {
  return window.localStorage.getItem("deviceId");
}
