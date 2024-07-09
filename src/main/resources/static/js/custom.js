$(document).ready(function() {
	(function($) {

		"use strict";

		// Testimonial Carousel
		if ($('.testimonial-carousel').length) {
			$('.testimonial-carousel').owlCarousel({
				animateOut: 'slideOutDown',
				animateIn: 'zoomIn',
				loop: true,
				margin: 0,
				nav: true,
				smartSpeed: 300,
				autoplay: 7000,
				navText: ['<span class="arrow-left"></span>', '<span class="arrow-right"></span>'],
				responsive: {
					0: {
						items: 1
					},
					600: {
						items: 1
					},
					800: {
						items: 1
					},
					1024: {
						items: 1
					}
				}
			});
		}

		// popular-courses Carousel
		if ($('.popular-courses-carousel').length) {
			$('.popular-courses-carousel').owlCarousel({
				animateOut: 'slideOutDown',
				animateIn: 'zoomIn',
				loop: true,
				margin: 15,
				nav: false,
				smartSpeed: 300,
				autoplay: 3000,
				navText: ['<span class="arrow-left"></span>', '<span class="arrow-right"></span>'],
				responsive: {
					0: {
						items: 1
					},
					600: {
						items: 2
					},
					800: {
						items: 2
					},
					1024: {
						items: 4
					}
				}
			});
		}

		// number count for stats, using jQuery animate

		$('.counting').each(function() {
			var $this = $(this),
				countTo = $this.attr('data-count');

			$({ countNum: $this.text() }).animate({
				countNum: countTo
			},

				{

					duration: 5000,
					easing: 'linear',
					step: function() {
						$this.text(Math.floor(this.countNum) + '+');
					},
					complete: function() {
						$this.text(this.countNum + '+');
					}

				});


		});

	})(window.jQuery);
});

document.addEventListener("DOMContentLoaded", function() {
	const readMoreLink = document.querySelector(".read-more");
	const readLessLink = document.querySelector(".read-less");
	const moreText = document.querySelector(".more-text");

	readMoreLink.addEventListener("click", function(event) {
		event.preventDefault();
		moreText.style.maxHeight = moreText.scrollHeight + "px";
		readMoreLink.style.display = "none";
		readLessLink.style.display = "inline";
	});

	readLessLink.addEventListener("click", function(event) {
		event.preventDefault();
		moreText.style.maxHeight = "0";
		readMoreLink.style.display = "inline";
		readLessLink.style.display = "none";
	});
});





document.addEventListener('DOMContentLoaded', function() {
	const sideMenu = document.getElementById('sideMenu');
	const backdrop = document.getElementById('backdrop');
	const rightIcon = document.getElementById('rightIcon');
	const closeBtn = document.getElementById('closeBtn');

	rightIcon.addEventListener('click', function() {
		sideMenu.style.right = '0'; // Slide in sidebar from right
		backdrop.style.display = 'block'; // Show backdrop
		document.body.style.overflow = 'hidden'; // Prevent scrolling
	});

	closeBtn.addEventListener('click', function() {
		sideMenu.style.right = '-314px'; // Slide out sidebar to right
		backdrop.style.display = 'none'; // Hide backdrop
		document.body.style.overflow = 'auto'; // Allow scrolling
	});

	backdrop.addEventListener('click', function() {
		sideMenu.style.right = '-314px'; // Slide out sidebar to right
		backdrop.style.display = 'none'; // Hide backdrop
		document.body.style.overflow = 'auto'; // Allow scrolling
	});
});




