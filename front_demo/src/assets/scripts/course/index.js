import * as $ from 'jquery';

export default (function () {
$('.my-course-toggle, .back-to-course').on('click', e => {
    $('.course-content').toggleClass('open');
    if($('.course-content').hasClass('open')){
    	$('.my-course-toggle').hide();
    } else {
	$('.my-course-toggle').show();
    }
    e.preventDefault();
  });



}())
