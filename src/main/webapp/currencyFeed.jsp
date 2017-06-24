<b>CURRENCY FEED</b>

<%--<div class ="col-sm-offset-3 col-sm-2">--%>
    <%--<table class ="table table-striped">--%>
        <%--<tr>--%>
            <%--<th>Symbol</th>--%>
            <%--<th>Bid</th>--%>
            <%--<th>Ask</th>--%>
            <%--<th>Change</th>--%>
            <%--<th></th>--%>
        <%--</tr>--%>
        <%--<tr ng-repeat="value in mainCtrl.forex">--%>
            <%--<td ng-if="$index < 7">{{value.symbol}}</td>--%>
            <%--<td class="greenColor" ng-if="$index < 7 && value.change > 0">{{value.bid}}</td>--%>
            <%--<td class="redColor" ng-if="$index < 7 && value.change < 0">{{value.bid}}</td>--%>
            <%--<td class="greenColor" ng-if="$index < 7 && value.change > 0">{{value.ask}}</td>--%>
            <%--<td class="redColor" ng-if="$index < 7 && value.change < 0">{{value.ask}}</td>--%>
            <%--<td class="greenColor" ng-if="$index < 7 && value.change > 0">{{value.change}}</td>--%>
            <%--<td class="redColor" ng-if="$index < 7 && value.change < 0">{{value.change}}</td>--%>
            <%--<td  ng-if="$index < 7 && value.change > 0" ng-include="'icon-up'"></td>--%>
            <%--<td  ng-if="$index < 7 && value.change < 0" ng-include="'icon-down'"></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
    <%--<h6>*source: <a href="https://www.instaforex.com" target="_blank" >https://www.instaforex.com</a></h6>--%>
<%--</div>--%>

<div>
    <script type="text/javascript">if (navigator.appName!="Microsoft Internet Explorer"){function receiveSize(e){document.getElementById("mt5iframe").style.height = e.data + "px";}window.addEventListener("message", receiveSize, false);}</script><iframe id="mt5iframe" src="https://informers.instaforex.com/forex_news/informer_vscrolling/sz=250_250&cn=5&r=1&hc=1&s=forex_news_online&sf=v&ss=10&sw=0&sd=0&si=0&sht=1&st=0&tf=v&ts=10&tw=0&td=0&ti=0&c1=ffffff&c2=ffffff&c3=333333&c4=8e2b2b&i=1" frameborder="0" width="250" height="100%" scrolling="no" title="InstaForex is a universal Forex portal for traders"></iframe><noframes><a href="https://www.instaforex.com/">InstaForex portal</a></noframes>
</div>
