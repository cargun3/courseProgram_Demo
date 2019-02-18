var request = require('request');
var qs = require('querystring');

module.exports = function (basePath) {
    function apiCall(basePath) {
        var OPTIONS = {
            headers: {'Content-Type': 'application/json; charset=utf-8'},
            url: null,
            body: null
        };
        
        const PORT = '8080';
        const BASE_PATH = basePath;
        var HOST = 'http://192.168.88.1';
        
        return {
            
            login : function (user_id, password, callback) {
                OPTIONS.url = HOST + ':' + PORT + BASE_PATH  +'/v1.0/users/login';
                OPTIONS.body = JSON.stringify({
                    "id": user_id,
                    "pw": password
                });
                request.post(OPTIONS, function (err, res, result) {
                    statusCodeErrorHandler(res.statusCode, callback, result);
                });
            },
            isLogin : function(token, callback) {
                OPTIONS.url = HOST + ':' + PORT + BASE_PATH  + '/v1.0/users/token';
                OPTIONS. headers = {'Content-Type': 'application/json', 'token': token};
                request.get(OPTIONS, function (err, res, result) {
                    statusCodeErrorHandler(res.statusCode, callback, result);
                });

            },
	    
            getMyCourse: function(req, callback) {
                OPTIONS.url = HOST + ':' + PORT + BASE_PATH + '/v1.0/user/list?memberSeq='+req.user.memberSeq;
		OPTIONS. headers = {'Content-Type': 'application/json'};
                request.get(OPTIONS, function (err, res, result) {
                    statusCodeErrorHandler(res.statusCode, callback, result);
                });

            },
           cancelMyCourse: function(req, callback) {
                OPTIONS.url = HOST + ':' + PORT + BASE_PATH + '/v1.0/removeInfo?seq=' + req.query.data;
                OPTIONS. headers = {'Content-Type': 'application/json'};
                request.delete(OPTIONS, function (err, res, result) {
                    statusCodeErrorHandler(res.statusCode, callback, result);
                });

            },

	    getCourseList: function(req, callback) {
                OPTIONS.url = HOST + ':' + PORT + BASE_PATH + '/v1.0/list?searchType=' + req.query.searchType + "&searchName=" + qs.escape(req.query.searchName);
                OPTIONS. headers = {'Content-Type': 'application/json'};
                request.get(OPTIONS, function (err, res, result) {
                    statusCodeErrorHandler(res.statusCode, callback, result);
                });

            },

	   registerCourse : function(req, callback) {
                OPTIONS.url = HOST + ':' + PORT + BASE_PATH + '/v1.0/register';
                OPTIONS.headers = {'Content-Type': 'application/json'};
		var body = new Object();
                body.courseList=req.body.courseList;
                body.memberSeq=req.user.memberSeq;
                OPTIONS.body = JSON.stringify(body);
                request.post(OPTIONS, function (err, res, result) {
                    statusCodeErrorHandler(res.statusCode, callback, result);
                });

            }
        };
    }
    
    function statusCodeErrorHandler(statusCode, callback , data) {
        switch (statusCode) {
            case 200:
                callback(null, JSON.parse(data));
                break;
            default:
                callback('error', JSON.parse(data));
                break;
        }
    }
    
    var INSTANCE;
    if (INSTANCE === undefined) {
        INSTANCE = new apiCall(basePath);
    }
    return INSTANCE;
};
