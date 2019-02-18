var API_Call = require('./api')('/course');

module.exports = {
 courseTest:function(req, res) {
    API_Call.courseTest(req.body, function (err, result) {
	res.send({result:result});
    });
 },

 getMyCourse: function(req, res) {
   API_Call.getMyCourse(req, function (err, result) {
        res.send({result:result});
   });
 },

cancelMyCourse: function(req, res) {
   API_Call.cancelMyCourse(req, function (err, result) {
        res.send({result:result});
   });
 },

getCourseList: function(req, res) {
   API_Call.getCourseList(req, function (err, result) {
        res.send({result:result});
   });
 },

registerCourse: function(req, res) {
   API_Call.registerCourse(req, function (err, result) {
        res.send({result:result});
   });
 },

}
