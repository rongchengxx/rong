
window.onscroll=function(){
var headNav=document.querySelector(".head-nav-box");
var sTop = document.documentElement.scrollTop==0?document.body:document.documentElement;
var STop=sTop.scrollTop;
	if (STop>110) {
		headNav.className="head-nav-box navBH"
	}else{
		headNav.className='head-nav-box'
	}
}
