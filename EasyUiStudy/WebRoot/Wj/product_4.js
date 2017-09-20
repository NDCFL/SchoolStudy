


//		    var swiperT = new Swiper('.swiper-container-top', {
//		        pagination: '.swiper-pagination-top',
//		        paginationClickable: true,
//		        parallax: true,
//		        speed: 600,
//		        loop: true,
//		        autoplay:5000,
//		        autoplayDisableOnInteraction: false
//		    });
		    var galleryTop = new Swiper('.gallery-top', {
		        spaceBetween: 10,
		        nextButton: '.swiper-button-next',
		        prevButton: '.swiper-button-prev',
		    });
		    var galleryThumbs = new Swiper('.gallery-thumbs', {
		        spaceBetween: 10,
		        centeredSlides: true,
		        slidesPerView: 'auto',
		        touchRatio: 0.2,
		        slideToClickedSlide: true,
		    });
		    galleryTop.params.control = galleryThumbs;
		    galleryThumbs.params.control = galleryTop;
		    $(document).ready(function(){
			 	$('.aaa').click(function(){
			    	$('.dd').trigger('click')
			    })
			    $('.bbb').click(function(){
			    	$('.cc').trigger('click')
			    })
		    })