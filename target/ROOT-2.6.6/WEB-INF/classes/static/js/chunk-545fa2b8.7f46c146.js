(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-545fa2b8"],{"79f7":function(e,t,a){},ab364:function(e,t,a){"use strict";a.r(t);var o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("Layout",[a("PageHeader",{attrs:{title:e.title,items:e.items}}),a("instagramSearchbar"),a("b-alert",{attrs:{show:"",variant:"secondary text-center"}},[a("i",{staticClass:"mdi mdi-14px mdi-alert-octagon"}),e._v(" 프로젝트에 신청한 모든 리뷰어를 최신 활동순으로 검색할 수 있습니다. ")]),a("instagramDataList")],1)},l=[],s=a("5658"),r=a("2579"),i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"row"},[a("div",{staticClass:"col-lg-12"},[a("div",{staticClass:"card"},[a("div",{staticClass:"card-body align-middle"},[a("div",{staticClass:"row"},[a("div",{staticClass:"col-lg-7"}),a("div",{staticClass:"col-lg-1"},[a("b-form-select",{attrs:{options:e.options},model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}})],1),a("div",{staticClass:"col-lg-2 searchBox"},[a("b-form-input",{attrs:{placeholder:"검색어를 입력하세요."},model:{value:e.searchText,callback:function(t){e.searchText=t},expression:"searchText"}})],1),a("div",{staticClass:"col-lg-2"},[a("b-button",{attrs:{variant:"primary",id:"searchBtn"}},[a("i",{staticClass:"fas fa-search align-middle mr-2"}),e._v(" 검색 ")])],1)])])])])])},n=[],m={data:function(){return{selected:"아이디",searchText:"",options:["아이디","메모"]}}},c=m,d=(a("d64b"),a("2877")),v=Object(d["a"])(c,i,n,!1,null,"7f46799a",null),p=v.exports,u=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"row"},[a("div",{staticClass:"col-lg-12"},[a("div",{staticClass:"card"},[a("div",{staticClass:"card-body"},[a("div",{staticClass:"table-responsive"},[a("b-table",{staticClass:"table-centered",attrs:{items:e.projectList,fields:e.projectHeader,responsive:"sm","per-page":e.perPage,"current-page":e.currentPage,"sort-by":e.sortBy,"sort-desc":e.sortDesc},on:{"update:sortBy":function(t){e.sortBy=t},"update:sort-by":function(t){e.sortBy=t},"update:sortDesc":function(t){e.sortDesc=t},"update:sort-desc":function(t){e.sortDesc=t}}})],1),a("div",{staticClass:"row"},[a("div",{staticClass:"col"},[a("div",{staticClass:"dataTables_paginate paging_simple_numbers float-right"},[a("ul",{staticClass:"pagination pagination-rounded mb-0"},[a("b-pagination",{attrs:{"total-rows":e.rows,"per-page":e.perPage},model:{value:e.currentPage,callback:function(t){e.currentPage=t},expression:"currentPage"}})],1)])])])])])])])},f=[],w={components:{},data:function(){return{projectHeader:[{key:"reviewer",label:"리뷰어"},{key:"post",label:"게시물"},{key:"follower",label:"팔로워"},{key:"following",label:"팔로잉"},{key:"like",label:"좋아요"},{key:"comment",label:"댓글"},{key:"memo",label:"메모"},{key:"lastFormDate",label:"마지막 신청일",sortable:!0},{key:"name",label:"이름"},{key:"email",label:"이메일"},{key:"tel",label:"전화번호"},{key:"address",label:"주소"}],projectList:[{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""},{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""},{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""},{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""},{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""},{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""},{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""},{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""},{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""},{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""},{reviewer:"홍길동",post:"123",follower:"2",following:"300",like:"20",comment:"3",memo:"",lastFormDate:"2021-03-18",name:"",email:"tjdxorv@naver.com",tel:"123",address:""}],totalRows:1,currentPage:1,perPage:10,sortBy:"no",sortDesc:!1}},computed:{rows:function(){return this.projectList.length}},methods:{moveSignupForm:function(e){console.log(e.item),this.$router.push({name:"signupForm",params:e.item})}}},g=w,b=Object(d["a"])(g,u,f,!1,null,null,null),k=b.exports,x={page:{meta:[{name:"reviewer instagram"}]},components:{Layout:s["a"],PageHeader:r["a"],instagramSearchbar:p,instagramDataList:k},data:function(){return{title:"리뷰어 목록 - 인스타그램",items:[{text:"리뷰어",href:"/reviewer/all"},{text:"인스타그램",active:!0}]}}},y=x,h=Object(d["a"])(y,o,l,!1,null,null,null);t["default"]=h.exports},d64b:function(e,t,a){"use strict";a("79f7")}}]);
//# sourceMappingURL=chunk-545fa2b8.7f46c146.js.map