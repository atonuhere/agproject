package com.gfs.erm.util;

import com.gfs.erm.web.common.WebConstants;

public class DefaultPageNavigator implements PageNavigator {

    private Integer start=0;
    private Integer end=0;
    private Integer pageNavTrail= WebConstants.PageNavTrail;
    
	 public String buildPageNav(String path, int resultSize, int page, int pageSize, String element) {
        int allPage = resultSize / pageSize;

        boolean isOdd = (resultSize % pageSize != 0);
        allPage = (isOdd ? allPage+1 : allPage);

        int iStart = page - pageNavTrail;
        int iEnd = page + pageNavTrail;

        if(iStart < 1) {
            iEnd = iEnd + (1-iStart);
            iStart = 1;

            if(iEnd > allPage) {
                iEnd = allPage;
            }
        } else if(iEnd > allPage) {
            iStart = iStart - (iEnd - allPage);
            iEnd = allPage;

            if(iStart < 1) {
                iStart = 1;
            }
        }
        this.end=(pageSize * page) - 1;
        this.start=(this.end-pageSize) + 1;
        
        if(this.end>resultSize)
        	this.end=resultSize;
        if(this.start<0)
        	this.start=0;
        
        StringBuffer sb = new StringBuffer();
        sb.append("<div class='pagination'><ul class='nav nav-pills'>");
        for(int i=iStart; i <=iEnd; i++) {
            if(i == page) {
                sb.append("<li class='active'><a href=\"javascript:void(0);\">").append(page).append("</a></li>").append(" ");
            }
            else {
                sb.append("<li><a href=\"javascript:ajaxPageLoad("+i+",'"+element+"')\">"+i+"</a></li>");
            }
        }
        sb.append("</ul></div>");
        return sb.toString();
    }
    
    public int getStart(){
    	return this.start;
    	
    }
    public int getEnd(){
    	return this.end;
    }
	
    /*<li class="prev disabled"><a href="#">&larr; Previous</a></li>
    <li class="active"><a href="#">1</a></li>
    <li class="next"><a href="#">Next &rarr;</a></li>*/
    
}
