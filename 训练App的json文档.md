# 训练App的json文档

## 注册

* url：/register

* 参数

  |  参数名  | 描述 |
  | :------: | :--: |
  | username |      |
  | password |      |

* 返回的json

  ```json
  {
      "status": 200,
      "info": "rigister successfull"
  }
  ```



## 登录

* url：/login

* 参数

  |  参数名  | 描述 |
  | :------: | :--: |
  | username |      |
  | password |      |

* 返回的json

  ```json
  {
      "status": 200,
      "info": "Login successfull",
      "data": {
          "name": "cy",
          "age": 0,
          "isCaptain": false
      }
  }
  ```

## 添加到个人的缺勤记录

* url：/addAbsent

* 参数

  |  参数名  |   描述   |
  | :------: | :------: |
  | username |          |
  |   time   |  时间戳  |
  | project  | 训练项目 |

* json

  ```json
  {
      "status": 200,
      "info": "add absent successful"
  }
  ```

## 添加个人请假

* url：/addLeave

* 参数

  |  参数名  |   描述   |
  | :------: | :------: |
  | username |          |
  |   time   |  时间戳  |
  | project  | 训练项目 |
  |  reason  | 请假原因 |

* json。如上

## 得到个人缺勤

* url：/getAbsents

* 参数

  |  参数名  | 描述 |
  | :------: | :--: |
  | username |      |

* json

  ```json
  {
      "status": 200,
      "info": "get absents successful",
      "data": [
          {
              "absentTime": 1580580122000,
              "absentProject": "test"
          }
      ]
  }
  ```

## 得到个人请假数据

* url：/getLeaves

* 参数

  |  参数名  | 描述 |
  | :------: | :--: |
  | username |      |

* json

  ```json
  {
      "status": 200,
      "info": "get leaves successful",
      "data": [
          {
              "leaveTime": 1583877674000,
              "leaveProject": "ssss",
              "leaveReason": "sssss"
          }
      ]
  }
  ```

## 添加团队数据

* url：/addTeamData

* 参数

  |  参数名  |  描述  |
  | :------: | :----: |
  | teamName |        |
  | project  |        |
  |   time   | 时间戳 |

* json

  ```json
  {
      "status": 200,
      "info": "ADD_DATA_SUCCESSFUL"
  }
  ```

## 获取团队数据

* url：getTeamData

* 参数

  |  参数名  | 描述 |
  | :------: | :--: |
  | teamName |      |

* json

  ```json
  {
      "status": 200,
      "info": "GET_DATA_SUCCESSFUL",
      "data": {
          "teamName": "scie",
          "trainData": [
              {
                  "trainPro": "test",
                  "trainTime": 1582708926000
              },
              {
                  "trainPro": "test",
                  "trainTime": 1582708926000
              }
          ],
          "totalTrainCount": 0
      }
  }
  ```

  