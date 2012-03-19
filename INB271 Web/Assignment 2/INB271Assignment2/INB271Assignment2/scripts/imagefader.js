/**
 * @author Dominic
 */
function imageFader() {
	//Make the opacity of all images to 0
	$('div#introimages ul li').css({opacity: 0.0});
	
	//First image now has full opacity
	$('div#introimages ul li:first').css({opacity: 1.0});
		
	//Use simple inbuilt (non jquery) js to call the function every 4s
	setInterval('change()',4000);
	
}

function change() {	
	//first image
	var current = ($('div#introimages ul li.show')?  $('div#introimages ul li.show') : $('div#introimages ul li:first'));

	//Get next image, when it reaches the end, rotate it back to the first image
	var next = ((current.next().length) ? ((current.next().hasClass('show')) ? $('div#introimages ul li:first') :current.next()) : $('div#introimages ul li:first'));	
	
	//the show class has a slightly higher z-index
	next.css({opacity: 0.0})
	.addClass('show')
	.animate({opacity: 1.0}, 1000);

	//Hide the current image
	current.animate({opacity: 0.0}, 1000)
	.removeClass('show');
	
};

$(document).ready(function() {		
	//Load the slideshow
	imageFader();
});