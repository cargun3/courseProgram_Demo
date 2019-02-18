var express = require('express');
var router = express.Router();
var auth = require('../lib/auth');
var course = require('../lib/course');   
 
router.get('/main',auth.isLoggedIn,function(req,res){
     res.render('course/course.html',{
             username: req.user.name,
             possibleScore: req.user.possibleScore
         });
});

router.post('/test', auth.isLoggedIn, function(req, res) {
	course.courseTest(req, res);
});

router.get('/get/mycourse', auth.isLoggedIn, function(req, res) {
        course.getMyCourse(req, res);
});


router.get('/cancel/mycourse', auth.isLoggedIn, function(req, res) {
        course.cancelMyCourse(req, res);
});

router.get('/get/courses', auth.isLoggedIn, function(req, res) {
        course.getCourseList(req, res);
});

router.post('/register', auth.isLoggedIn, function(req, res) {
        course.registerCourse(req, res);
});


module.exports = router;
