<template>
<div>
<!-- 프로젝트 리스트 -->
<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-body">
        <div class="text-right">
          <a href="javascript:void(0);" class="btn btn-success mb-2" @click="openReviewerForm = true">
            <i class="mdi mdi-plus mr-2"></i> 블로거 등록
          </a>
        </div>
        <div class="table-responsive mt-3">
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

<!-- Modal -->
<b-modal
  v-model="openReviewerForm"
  title="블로거 등록"
  title-class="text-dark font-18"
  hide-footer
>   
    <b-form ref="form">
    <!-- 이름 -->
    <ComInput v-model="bloger.name" title="* 성명" />
    <!-- 카카오 ID -->
    <ComInput v-model="bloger.kakaoId" title="카카오 ID" />
    <!-- 나이 -->
    <ComInput v-model="bloger.age" title="나이" type="number" />
    <!-- 블로그 명 -->
    <ComInput v-model="bloger.blogNm" title="블로그 명" />
    <!-- 블로그 주소 -->
    <ComInput v-model="bloger.link" title="블로그 주소" />
    <!-- 이메일 -->
    <ComInput v-model="bloger.email" title="이메일" type="email"/>
    <!-- 전화번호 -->
    <ComInput v-model="bloger.phone" title="전화번호" />
    <!-- 주소 -->
    <ComInput v-model="bloger.address" title="주소" type="textarea"/>
    <!-- 일방문자수 -->
    <ComInput v-model="bloger.visit" title="일 방문자 수" type="number" />
    <!-- 게시물 수  -->
    <ComInput v-model="bloger.postNum" title="게시물 수" type="number" />
    <!-- 중요도 -->
    <ComInput v-model="bloger.important" type="select" :items="importantCombo" />
    <!-- 카테고리 -->
    <ComInput v-model="bloger.category" type="select" :items="categoryCombo" />
    <!-- 비고 -->
    <ComInput v-model="bloger.remark" title="비고" type="textarea"/>
    </b-form>

    <!-- Button -->
    <div class="text-right">
      <button type="submit" class="btn btn-success" @click="createBloger">블로거 등록</button>
      <b-button class="ml-1" variant="danger" @click="hideModal">닫기</b-button>
    </div>
        
</b-modal>

</div>
</template>
<script>
import ComInput from '../common/ComInput';
import Vue from "vue";
import { reviewerMethods } from '@/state/helpers'

export default {
  components: {
    ComInput
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

      // 중요도 콤보
      importantCombo: [
        {value: '', text: '* 중요도 선택'},
        {value: '0', text: '중요도-0'},
        {value: '1', text: '중요도-1'},
        {value: '2', text: '중요도-2'},
        {value: '3', text: '중요도-3'},
        {value: '4', text: '중요도-4'},
        {value: '5', text: '중요도-5'},
      ],

      // 카테고리 콤보
      categoryCombo: [
        {value: '', text: '* 카테고리 선택'},
        {value: 'category0', text: '카테고리-0'},
        {value: 'category1', text: '카테고리-1'},
        {value: 'category2', text: '카테고리-2'},
        {value: 'category3', text: '카테고리-3'},
        {value: 'category4', text: '카테고리-4'},
        {value: 'category5', text: '카테고리-5'},
      ],

      // Form 데이터
      bloger: {
        name: '',
        kakaoId: '',
        age: '',
        blogNm: '',
        link: '',
        email: '',
        phone: '',
        address: '',
        visit: '',
        postNum: '',
        important: '',
        category: '',
        remark: '',
      },

      submitted: false,
      // 리뷰어 폼 모달 상태
      openReviewerForm: false,
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
    ...reviewerMethods,

    moveSignupForm(row) {
      console.log(row.item);
      this.$router.push({
        name: 'signupForm',
        params: row.item
      })
    },

    // eslint-disable-next-line no-unused-vars
    handleSubmit(e) {
      this.submitted = true;

      // stop here if form is invalid
      this.$v.$touch();
      if (this.$v.$invalid) {
        return;
      } else {
        const name = this.customers.name;
        const balance = this.customers.balance;
        const email = this.customers.email;
        const phone = this.customers.phone;
        const date = this.customers.date;
        this.customersData.push({
          name,
          email,
          balance,
          phone,
          date
        });
        this.showmodal = false;
      }
      this.submitted = false;
      this.customers = {};
    },

    // eslint-disable-next-line no-unused-vars
    hideModal(e) {
      this.submitted = false;
      this.showmodal = false;
      this.contacts = {};
    },

    // 블로거 등록
    createBloger() {
      const param = this.bloger
      console.log(this)
      
      if(!param.name) {
        Vue.swal("성함을 입력해 주세요.").then(() => { return });
      } else if(!param.important) {
        Vue.swal("중요도를 선택해 주세요.").then(() => { return });
      } else if(!param.category) {
        Vue.swal("카테고리를 선택해 주세요.").then(() => { return });
      } else {
        this.CREATE_BLOGER(param)
      }

    }
  }
};
</script>