<ul class="pagination pagination-lg">
    <g:if test="${nbpages > 0}">
        <g:each var="page" in="${1..nbpages}">
            <li class="${offset == page-1 ?'active':''}"><a href="<g:createLink action="list" params="[offset : page -1]"/>" >${page}</a></li>
        </g:each>
    </g:if>
</ul>