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
            <template v-slot:cell(state)="row">
              <div
                class="badge font-size-12 text-center"
                :class="{'badge-soft-danger': `${row.value}` === '시작전',
                    'badge-soft-success': `${row.value}` === '완료',
                    'badge-soft-warning': `${row.value}` === '진행중'}"
              >{{ row.value }}</div>
            </template>
            <template v-slot:cell(invoice)>
              <button class="btn btn-light btn-rounded">
                Invoice
                <i class="mdi mdi-download ml-2"></i>
              </button>
            </template>
            <template v-slot:cell(action)="row">
              <div class="row justify-content-end">
              <b-button
                class="mr-1"
                variant="primary"
                v-b-tooltip.hover
                title="수정"
                size="sm"
              >
                <i class="mdi mdi-pencil font-size-15"></i>
              </b-button>
              <b-button
                class="mr-1"  
                variant="danger"
                v-b-tooltip.hover
                title="삭제"
                size="sm"
              >
                <i class="mdi mdi-trash-can font-size-15"></i>
              </b-button>
              <b-button
                variant="secondary"
                v-b-tooltip.hover
                title="신청서"
                size="sm"
                @click="moveSignupForm(row)"
              >
                <i class="mdi mdi-file-document font-size-15"></i>
              </b-button>
              </div>
            </template>
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
        { key: "blogNm", label: "블로그명" },
        { key: "gender", label: "성별" },
        { key: "age", sortable: true, label: "연령대" },
        { key: "memo", label: "메모" },
        { key: "lastFormDate", sortable: false, label: "마지막 신청일" },
        { key: "name", sortable: false, label: "이름" },
      ],
      projectList: [
        { reviewer: "홍길동", blogNm: "홍길동블로그", gender: "남자", age: "23", memo: "", lastFormDate: "2022-01-03", name: "홍길동" },
        { reviewer: "홍길동", blogNm: "홍길동블로그", gender: "남자", age: "23", memo: "", lastFormDate: "2022-01-03", name: "홍길동" },
        { reviewer: "홍길동", blogNm: "홍길동블로그", gender: "남자", age: "23", memo: "", lastFormDate: "2022-01-03", name: "홍길동" },
        { reviewer: "홍길동", blogNm: "홍길동블로그", gender: "남자", age: "23", memo: "", lastFormDate: "2022-01-03", name: "홍길동" },
        { reviewer: "홍길동", blogNm: "홍길동블로그", gender: "남자", age: "23", memo: "", lastFormDate: "2022-01-03", name: "홍길동" },
        { reviewer: "홍길동", blogNm: "홍길동블로그", gender: "남자", age: "23", memo: "", lastFormDate: "2022-01-03", name: "홍길동" },
        { reviewer: "홍길동", blogNm: "홍길동블로그", gender: "남자", age: "23", memo: "", lastFormDate: "2022-01-03", name: "홍길동" },
        { reviewer: "홍길동", blogNm: "홍길동블로그", gender: "남자", age: "23", memo: "", lastFormDate: "2022-01-03", name: "홍길동" },
        { reviewer: "홍길동", blogNm: "홍길동블로그", gender: "남자", age: "23", memo: "", lastFormDate: "2022-01-03", name: "홍길동" },
        { reviewer: "홍길동", blogNm: "홍길동블로그", gender: "남자", age: "23", memo: "", lastFormDate: "2022-01-03", name: "홍길동" },
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