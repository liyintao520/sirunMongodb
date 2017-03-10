(function($) {
	/**
	 * 分页(pageId-显示Div，totalNum-总条数， pageNo-当前页，pageSize-每页显示条数)
	 * @param pageId
	 * @param totalNum
	 * @param pageNo
	 * @param pageSize
	 */
	page = function(pageId, totalNum, pageNo, pageSize) {
		$("#" + pageId).pagination(totalNum, {
			callback : PageCallback, //PageCallback() 为翻页调用函数。
			prev_text : "上一页",
			next_text : "下一页",
			items_per_page : parseInt(pageSize),
			num_edge_entries : 2, //两侧首尾分页条目数
			num_display_entries : 5, //连续分页主体部分分页条目数
			current_page : parseInt(pageNo)//当前页索引
		});
	}
})(jQuery);