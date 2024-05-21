
$(".openbtn4").click(function() {
	$(this).toggleClass('active');
	$("#g-nav").toggleClass('panelactive');
	$(".circle-bg").toggleClass('circleactive');
});


$("#g-nav a").click(function() {//ナビゲーションのリンクがクリックされたら
	$(".openbtn1").removeClass('active');//ボタンの activeクラスを除去し
	$("#g-nav").removeClass('panelactive');//ナビゲーションのpanelactiveクラスを除去
	$(".circle-bg").removeClass('circleactive');//丸背景のcircleactiveクラスを除去
});