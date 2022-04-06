<template>
<!-- 프로젝트 리스트 -->
<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-body">

        <div class="table-responsive">
          <b-table
            class="table-centered"
            :items="projectList"
            :fields="projectHeader"
            responsive="sm"
            :per-page="perPage"
            :current-page="currentPage"
            :sort-by.sync="sortBy"
            :sort-desc.sync="sortDesc"
          >
          </b-table>
        </div>
        
        <div class="row">
          <div class="col">
            <div class="dataTables_paginate paging_simple_numbers float-right">
              <ul class="pagination pagination-rounded mb-0">
                <!-- pagination -->
                <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage"></b-pagination>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

</template>
<script>
export default {
  components: {
  },
  data() {
    return {
      projectHeader: [
        { key: "reviewer", label: "리뷰어", },
        { key: "post", label: "게시물" },
        { key: "follower", label: "팔로워" },
        { key: "following", label: "팔로잉" },
        { key: "like", label: "좋아요" },
        { key: "comment", label: "댓글",  },
        { key: "memo", label: "메모" },
        { key: "lastFormDate", label: "마지막 신청일", sortable: true },
        { key: "name", label: "이름" },
        { key: "email", label: "이메일" },
        { key: "tel", label: "전화번호" },
        { key: "address", label: "주소" },
      ],
      projectList: [
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
        { reviewer: "홍길동", post: "123", follower: "2", following: "300", like: "20", comment: "3", memo: "", lastFormDate: '2021-03-18', name: '', email: 'tjdxorv@naver.com', tel: '123', address: '' },
      ],
      totalRows: 1,
      currentPage: 1,
      perPage: 10,
      sortBy: "no",
      sortDesc: false,  
    };
  },
  computed: {
    /**
     * Total no. of records
     */
    rows() {
      return this.projectList.length;
    }
  },
  methods: {
    moveSignupForm(row) {
      console.log(row.item);
      this.$router.push({
        name: 'signupForm',
        params: row.item
      })
    }
  }
};
</script>