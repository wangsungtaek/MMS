<template>
<div>
<!-- 프로젝트 리스트 -->
<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-body">
        <div class="text-right">
          <a href="javascript:void(0);" class="btn btn-success mb-2" @click="openForm">
            <i class="mdi mdi-plus mr-2"></i>블로거 등록
          </a>
        </div>
        <div class="table-responsive mt-3">

          <!-- data Table -->
          <b-table
            class="table-centered"
            :items="blogerList"
            :fields="gridHeader"
            responsive="sm"
            :per-page="perPage"
            :current-page="currentPage"
            :sort-by.sync="sortBy"
            :sort-desc.sync="sortDesc"
          >
            <!-- 중요도 확인 -->
            <template v-slot:cell(important)="row">
              <div class="badge font-size-12 text-center"
                :class="{'badge-soft-secondary': `${row.value}` === '0',
                    'badge-soft-success': `${row.value}` === '1',
                    'badge-soft-info': `${row.value}` === '2',
                    'badge-soft-danger': `${row.value}` === '3',
                    'badge-soft-primary': `${row.value}` === '4'}"
              >{{row.value}}</div>
            </template>

            <!-- 이름 -->
            <template v-slot:cell(reviewerNm)="row">
              <b-button variant="link" @click="selectRow(row.item)">
                {{row.value}}
              </b-button>
            </template>

            <!-- 링크 -->
            <template v-slot:cell(blogLink)="row">
              <a :href="`${row.value}`" target=”_blank”>
                {{row.value}}
              </a>
            </template>
          </b-table>

        </div>

        <!-- Page Nation -->
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

<!-- Form Modal -->
<b-modal
  v-model="openReviewerForm"
  :title="title"
  title-class="text-dark font-18"
  hide-footer
>   
    <b-form ref="form">
    <!-- ID -->
    <ComInput v-model="bloger.reviewerId" title="ID" v-if="isUpdate" :disable="isUpdate" />
    <!-- 이름 -->
    <ComInput v-model="bloger.reviewerNm" title="* 이름" />
    <!-- 카카오 ID -->
    <ComInput v-model="bloger.kakaoId" title="카카오 ID" />
    <!-- 나이 -->
    <ComInput v-model="bloger.age" title="나이" type="number" />
    <!-- 블로그 명 -->
    <ComInput v-model="bloger.blogNm" title="블로그 명" />
    <!-- 블로그 주소 -->
    <ComInput v-model="bloger.blogLink" title="블로그 주소" />
    <!-- 이메일 -->
    <ComInput v-model="bloger.email" title="이메일" type="email"/>
    <!-- 전화번호 -->
    <ComInput v-model="bloger.telNo" title="전화번호" />
    <!-- 주소 -->
    <ComInput v-model="bloger.address" title="주소" type="textarea"/>
    <!-- 일방문자수 -->
    <ComInput v-model="bloger.visit" title="일 방문자 수" type="number" />
    <!-- 게시물 수  -->
    <ComInput v-model="bloger.postNo" title="게시물 수" type="number" />
    <!-- 중요도 -->
    <ComInput v-model="bloger.important" type="select" :items="importantCombo" />
    <!-- 카테고리 -->
    <ComInput v-model="bloger.category" type="select" :items="categoryCombo" />
    <!-- 비고 -->
    <ComInput v-model="bloger.remark" title="비고" type="textarea"/>
    </b-form>

    <!-- Button -->
    <div class="text-right" v-if="!isUpdate">
      <button class="btn btn-success" @click="createBloger">블로거 등록</button>
      <b-button class="ml-1" variant="danger" @click="openReviewerForm = false">닫기</b-button>
    </div>
    <div class="text-right" v-if="isUpdate">
      <b-button variant="primary" @click="updateBloger">수 정</b-button>
      <b-button variant="danger" class="ml-2" @click="deleteBloger">삭 제</b-button>
    </div>
        
</b-modal>

</div>
</template>np
<script>
import ComInput from '../common/ComInput'
import Swal from "sweetalert2";
import { reviewerComputed, reviewerMethods, categoryComputed, categoryMethods } from '@/state/helpers'

export default {
  components: {
    ComInput
  },
  data() {
    return {
      gridHeader: [
        { key: "important", sortable: true, label: "중요도"},
        { key: "reviewerNm", sortable: false, label: "이름", width: '100px'},
        { key: "kakaoId", sortable: false, label: "카카오 ID" },
        { key: "age", sortable: false, label: "나이" },
        { key: "category", sortable: true, label: "카테고리" },
        { key: "blogNm", sortable: false, label: "블로그 명" },
        { key: "blogLink", sortable: false,label: "블로그 주소" },
        { key: "email", sortable: false, label: "이메일" },
        { key: "telNo", sortable: false, label: "전화번호" },
        { key: "visit", sortable: true, label: "일 방문자 수" },
        { key: "postNo", sortable: true, label: "게시물 수" },
      ],

      totalRows: 1,
      currentPage: 1,
      perPage: 8,
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
      ],

      // Form 데이터
      bloger: {
        reviewerId: '',
        reviewerNm: '',
        kakaoId: '',
        age: '',
        blogNm: '',
        blogLink: '',
        email: '',
        telNo: '',
        address: '',
        visit: '',
        postNo: '',
        important: '',
        category: '',
        remark: '',
      },

      // 리뷰어 폼 모달 상태
      isUpdate: false,
      openReviewerForm: false,
    };
  },
  computed: {
    ...reviewerComputed,
    ...categoryComputed,

    title() {
      return this.isUpdate ? '블로거 수정' : '블로거 등록'
    },
    rows() {
      return this.blogerList.length;
    }
  },
  created() {
    this.FATCH_BLOGER();
    this.FATCH_CATEGORY();
  },
  methods: {
    ...reviewerMethods,
    ...categoryMethods,

    // Form 초기화
    initForm() {
      this.bloger.reviewerNm = '';
      this.bloger.kakaoId = '';
      this.bloger.age = '';
      this.bloger.blogNm = '';
      this.bloger.blogLink = '';
      this.bloger.email = '';
      this.bloger.telNo = '';
      this.bloger.address = '';
      this.bloger.visit = '';
      this.bloger.postNo = '';
      this.bloger.important = '';
      this.bloger.category = '';
      this.bloger.remark = '';
    },

    // 데이터 확인
    validForm() {
      const param = this.bloger
      if(!param.reviewerNm) {
        Swal.fire("성함을 입력해 주세요.", "", "warning").then(() => { return false });
      } else if(!param.important) {
        Swal.fire("중요도를 선택해 주세요.", "", "warning").then(() => { return false });
      } else if(!param.category) {
        Swal.fire("카테고리를 선택해 주세요.", "", "warning").then(() => { return false });
      } else {
        return true
      }
    },

    // Form Open
    openForm() {
      this.isUpdate = false
      this.openReviewerForm = true
      this.initForm()
    },

    // 블로거 등록
    createBloger() {
      if(this.validForm()) {
        this.CREATE_BLOGER(this.bloger)
          .then((result) => {
            console.log(result)
            Swal.fire("등록 완료", "", "success").then(() => { 
              this.openReviewerForm = false
              this.FATCH_BLOGER();
              this.initForm();
            });
          })
      }
    },

    // Row 선택
    selectRow(row) {
      this.isUpdate = true
      this.openReviewerForm = true
      this.bloger.reviewerId = row.reviewerId;
      this.bloger.reviewerNm = row.reviewerNm;
      this.bloger.kakaoId = row.kakaoId;
      this.bloger.age = row.age;
      this.bloger.blogNm = row.blogNm;
      this.bloger.blogLink = row.blogLink;
      this.bloger.email = row.email;
      this.bloger.telNo = row.telNo;
      this.bloger.address = row.address;
      this.bloger.visit = row.visit;
      this.bloger.postNo = row.postNo;
      this.bloger.important = row.important;
      this.bloger.category = row.category;
      this.bloger.remark = row.remark;
    },

    // 블로거 업데이트
    updateBloger() {
      if( this.validForm() ) {
        this.UPDATE_BLOGER(this.bloger)
          .then((result) => {
            if(result) {
              Swal.fire("수정 완료", "", "success").then(() => { 
                this.openReviewerForm = false
                this.FATCH_BLOGER();
                this.initForm();
              });
            }
          })
      }
    },

    // 블로거 삭제
    deleteBloger() {  
      Swal.fire({
        title: "블로거 삭제",
        text: "해당 블로거를 삭제하시겠습니까?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#34c38f",
        cancelButtonColor: "#f46a6a",
        confirmButtonText: "삭 제",
        cancelButtonText: "취 소",
      }).then(result => {
        if (result.value) {
          this.DELETE_BLOGER(this.bloger).then(result => {
            if(result) {
              Swal.fire("삭제", "해당 블로거가 삭제되었습니다.", "success").then(() => {
                this.openReviewerForm = false
                this.FATCH_BLOGER();
              });
            }
          })
            
        }
      });
    },
    
  }
};
</script>