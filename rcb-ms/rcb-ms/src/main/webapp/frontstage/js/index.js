// 轮播图图片长度设置
var bannerBox=document.querySelector(".banner-box");
var bannerTuBox=document.querySelector(".banner-tuBox");
var bannerA=document.querySelectorAll(".banner-tuBox>a");
resize();
function resize(){
	var bannerBoxW=bannerBox.offsetWidth;
	bannerTuBox.style.width=bannerBoxW*bannerA.length+"px";
	for (var i = bannerA.length - 1; i >= 0; i--) {
		bannerA[i].style.width=bannerBoxW+"px";
	};
}
window.addEventListener("resize",function(){
	resize();
})



// 轮播图按钮长度设置
var bannerBtn=document.querySelector('.banner-btn');
var bannerBtnI=document.querySelectorAll(".banner-btn>i");
var bannerBtnW=bannerBtnI.length*25;
var that=0;
bannerBtn.style.width=bannerBtnW+"px";
bannerBtn.style.marginLeft=-bannerBtnW/2+"px";



// 轮播图动画效果
var num=0;
function move(){
	num++;
	if (num==bannerA.length) {
		num=0;
	};
	bannerTuBox.style.marginLeft=-bannerBox.offsetWidth*num+"px";
	for (var i = bannerBtnI.length - 1; i >= 0; i--) {
		bannerBtnI[i].className="";
	};
	bannerBtnI[num].className="clickBtn";
}
var t=setInterval(move,3000);



// 轮播图按钮点击效果
for (var i = bannerBtnI.length - 1; i >= 0; i--) {
	bannerBtnI[i].index=i;
	bannerBtnI[i].onclick=function(){
		for (var j = bannerA.length - 1; j >= 0; j--) {
			bannerBtnI[j].className="";
		};
		bannerBtnI[this.index].className="clickBtn";
		bannerTuBox.style.marginLeft=-bannerBox.offsetWidth*this.index+"px";
	}
};
bannerBox.onmouseover=function(){
	clearInterval(t)
}
bannerBox.onmouseout=function(){
	t=setInterval(move,3000);
}