<template>
<div id="reviewerList">
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

<!-------------------------------------------------------------------------------------
  * Form Modal 
-------------------------------------------------------------------------------------->
<b-modal
  v-model="openReviewerForm"
  id="formModal"
  :title="title"
  scrollable
>   
    <b-form ref="form">
    <!-- ID -->
    <ComInput v-model="reviewer.reviewerId" title="ID" v-if="isUpdate" :disable="isUpdate" :isGridSystem=true />  
    <!-- 이름 -->
    <ComInput v-model="reviewer.reviewerNm" title="* 이름" :isGridSystem=true />
    <!-- 카카오 ID -->
    <ComInput v-model="reviewer.kakaoId" title="카카오 ID" :isGridSystem=true />
    <!-- 나이 -->
    <ComInput v-model="reviewer.age" title="나이" type="number" :isGridSystem=true />
    <!-- 블로그 주소 -->
    <ComInput v-model="reviewer.blogLink" title="블로그 주소" :isGridSystem=true />
    <!-- 인스타그램 주소 -->
    <ComInput v-model="reviewer.instagramLink" title="인스타그램 주소" :isGridSystem=true />
    <!-- 유튜브 주소 -->
    <ComInput v-model="reviewer.youtubeLink" title="유튜브 주소" :isGridSystem=true />
    <!-- 이메일 -->
    <ComInput v-model="reviewer.email" title="이메일" type="email" :isGridSystem=true />
    <!-- 전화번호 -->
    <ComInput v-model="reviewer.telNo" title="전화번호" :isGridSystem=true />
    <!-- 주소 -->
    <ComInput v-model="reviewer.address" title="주소" type="textarea" :isGridSystem=true />
    <!-- 일방문자수 -->
    <ComInput v-model="reviewer.visit" title="일 방문자 수" type="number" :isGridSystem=true />
    <!-- 게시물 수  -->
    <ComInput v-model="reviewer.postNo" title="게시물 수" type="number" :isGridSystem=true />
    <!-- 중요도 -->
    <ComInput v-model="reviewer.important" title="중요도" type="select" :items="importantCombo" :isGridSystem=true />
    <!-- 카테고리 -->
    <ComInput v-model="reviewer.category" title="카테고리" type="select" :items="categoryCombo" :isGridSystem=true />
    <!-- 비고 -->
    <ComInput v-model="reviewer.remark" title="비고" type="textarea" :isGridSystem=true />
    </b-form>

    <template v-slot:modal-footer>
    <!-- Button -->
    <div class="text-right" v-if="!isUpdate">
      <button class="btn btn-primary" @click="createReviewer">등 록</button>
      <b-button class="ml-2" variant="danger" @click="openReviewerForm = false">닫 기</b-button>
    </div>
    <div class="text-right" v-if="isUpdate">
      <b-button variant="primary" @click="updateReviewer">수 정</b-button>
      <b-button variant="danger" class="ml-2" @click="deleteReviewer">삭 제</b-button>
    </div>
    </template>
        
</b-modal>

</div>
</template>


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
      reviewer: {
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
      return this.isUpdate ? '리뷰어 수정' : '리뷰어 등록'
    },
    rows() {
      return this.blogerList.length;
    }
  },
  created() {
    this.FATCH_REVIEWER();
    this.FATCH_CATEGORY();
  },

  /*********************************************************************************
   * METHODS
  *********************************************************************************/ 
  methods: {
    ...reviewerMethods,
    ...categoryMethods,

    /*****************************************
     * 메서드 Form 초기화
    ******************************************/ 
    initForm() {
      this.reviewer.reviewerNm = '';
      this.reviewer.kakaoId = '';
      this.reviewer.age = '';
      this.reviewer.blogNm = '';
      this.reviewer.blogLink = '';
      this.reviewer.instagramLink = '';
      this.reviewer.youtubeLink = '';
      this.reviewer.email = '';
      this.reviewer.telNo = '';
      this.reviewer.address = '';
      this.reviewer.visit = '';
      this.reviewer.postNo = '';
      this.reviewer.important = '';
      this.reviewer.category = '';
      this.reviewer.remark = '';
    },

    /*****************************************
     * 리뷰어 선택
    ******************************************/ 
    selectRow(row) {
      this.isUpdate = true
      this.openReviewerForm = true
      this.reviewer.reviewerId = row.reviewerId;
      this.reviewer.reviewerNm = row.reviewerNm;
      this.reviewer.kakaoId = row.kakaoId;
      this.reviewer.age = row.age;
      this.reviewer.blogNm = row.blogNm;
      this.reviewer.blogLink = row.blogLink;
      this.reviewer.email = row.email;
      this.reviewer.telNo = row.telNo;
      this.reviewer.address = row.address;
      this.reviewer.visit = row.visit;
      this.reviewer.postNo = row.postNo;
      this.reviewer.important = row.important;
      this.reviewer.category = row.category;
      this.reviewer.remark = row.remark;
    },
    
    /*****************************************
     * 데이터 확인
    ******************************************/ 
    async validForm() {

      if(!this.reviewer.reviewerNm) {
        await Swal.fire("성함을 입력해 주세요.", "", "warning");
        return false;
      }  
      if(!this.reviewer.important) {
        await Swal.fire("중요도를 선택해 주세요.", "", "warning");
        return false;
      } 
      if(!this.reviewer.category) {
        await Swal.fire("카테고리를 선택해 주세요.", "", "warning");
        return false;
      } 
      return true;
    },

    /*****************************************
     * Form 모달 OPEN
    ******************************************/ 
    openForm() {
      this.isUpdate = false
      this.openReviewerForm = true
      this.initForm();
    },

    /*****************************************
     * 리뷰어 등록
    ******************************************/ 
    async createReviewer() {
      if(await this.validForm()) {
        console.log(this.validForm());
        const result = await this.CREATE_REVIEWER(this.reviewer);
        if(result) {
          await Swal.fire("등록 완료", "", "success");
          this.openReviewerForm = false
          this.FATCH_REVIEWER();
          this.initForm();
        }
      }
    },

    /*****************************************
     * 리뷰어 수정
    ******************************************/ 
    async updateReviewer() {
      if(await this.validForm()) {
        const result = await this.UPDATE_REVIEWER(this.reviewer);

        if(result) {
          await Swal.fire("수정 완료", "", "success");
          this.openReviewerForm = false
          this.FATCH_REVIEWER();
          this.initForm();
        }
      }
    },

    /*****************************************
     * 리뷰어 삭제
    ******************************************/ 
    async deleteReviewer() {  
      const result = await Swal.fire({
        title: "리뷰어 삭제",
        text: "해당 리뷰어를 삭제하시겠습니까?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#34c38f",
        cancelButtonColor: "#f46a6a",
        confirmButtonText: "삭 제",
        cancelButtonText: "취 소",
      })
      if(result.value) {
        await this.DELETE_REVIEWER(this.reviewer);
        if(result) {
          await Swal.fire("삭제", "리뷰어가 삭제되었습니다.", "success");
          this.openReviewerForm = false;
          this.FATCH_REVIEWER();
        }  
      }
    },
    
  }
};
</script>
<style>
#formModal .modal-dialog {
  top: 10%;
}
#formModal .modal-body { 
  height: 600px;
}
</style>