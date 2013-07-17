$(function() {
	var pingfen = 3;
	var vid = 7177;

	$('#thismark').rater(null,
					{
						maxvalue : 5,
						curvalue : 3
					},
					function(el, value) {
						$('#choosingmark').html('您选择的分值是<strong class="pingfen">' + value + '</strong>分');
						pingfen = value;
						$("#score").val(pingfen);
					});

	var liao = $("#avg").val();
	var jiang = $("#total").val();
	$("#pnum").html("(有" + jiang + "位用户作出评价)");
	$('#curmark').rater(null, {
		maxvalue : 5,
		curvalue : liao,
		enabled : false
	});
	$("#score").val(pingfen);
});