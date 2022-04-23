<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-body align-middle">
          <div class="row mt-2">
            
            <!-- left -->
            <div class="col-lg-4">

              <!-- 프로젝트 ID -->
              <!-- <div class="row">
                <div class="col-lg-4 my-auto text-right">
                  <label for="projectId" class="m-0">프로젝트 ID</label>
                </div>
                <div class="col-lg-7">
                  <b-form-input v-model="projectForm.PROJECT_ID" disabled id="projectId" placeholder="PROJECT ID"></b-form-input>
                </div>
              </div> -->

              <!-- 프로젝트 명 -->
              <div class="row">
                <div class="col-lg-4 my-auto text-right">
                  <label for="projectName" class="m-0">프로젝트 명</label>
                </div>
                <div class="col-lg-7">
                  <b-form-input v-model="projectForm.PROJECT_NM" id="projectName" class="" required></b-form-input>
                </div>
              </div>

              <!-- 시작일 -->
              <div class="row mt-4">
                <div class="col-lg-4 my-auto text-right">
                  <label for="projectStartDate" class="m-0">시작일</label>
                </div>
                <div class="col-lg-7">
                  <b-form-input v-model="projectForm.START_DT" type="date" id="projectStartDate"></b-form-input>
                </div>
              </div>

              <!-- 종료일 -->
              <div class="row mt-4">
                <div class="col-lg-4 my-auto text-right">
                  <label for="projectEndDate" class="m-0">종료일</label>
                </div>
                <div class="col-lg-7">
                  <b-form-input v-model="projectForm.END_DT" type="date" id="projectEndDate"></b-form-input>
                </div>
              </div>

              <!-- 모집인원 -->
              <div class="row mt-4">
                <div class="col-lg-4 my-auto text-right">
                  <label for="people" class="m-0">모집인원</label>
                </div>
                <div class="col-lg-7">
                  <b-form-input v-model="projectForm.PERSONNEL" id="people" type="number" min="1" max="200"></b-form-input>
                </div>
              </div>

              <!-- 메모 -->
              <div class="row mt-4">
                <div class="col-lg-4 text-right">
                  <label for="memo" class="m-0">메모</label>
                </div>
                <div class="col-lg-7">
                  <textarea
                    v-model="projectForm.MEMO"
                    class="form-control"
                    name="textarea"
                    rows="5"
                  ></textarea>
                </div>
              </div>

            </div>

            <!-- right -->
            <div class="col-lg-8">

              <!-- 이미지 등록 -->
              <div class="row">
                <div class="col-lg-2 text-right">
                  <label for="memo" class="m-0">이미지</label>
                </div>
                <div class="col-lg-4">
                  <img
                    class="rounded mr-2"
                    height="119"
                    src="@/assets/images/small/img-4.jpg"
                    data-holder-rendered="true"
                  />
                </div>
                <div class="col-lg-5">
                  <b-button variant="primary" id="searchBtn">
                    <i class="fas fa-upload align-middle mr-2"></i>
                    이미지 선택
                  </b-button>
                  <div id="imgComment">
                    <i class="fas fa-file-image"></i>
                    400px × 400px (GIF/JPG/PNG)
                  </div>
                </div>
              </div>

              <!-- 제품링크 -->
              <div class="row mt-4">
                <div class="col-lg-2 my-auto text-right">
                  <label for="memo" class="m-0">제품링크</label>
                </div>
                <div class="col-lg-10">
                  <b-form-input v-model="projectForm.LINK" id="link"></b-form-input>
                </div>
              </div>

              <!-- 상세정보 -->
              <div class="row mt-4">
                <div class="col-lg-2 text-right">
                  <label for="detailInfo" class="m-0">상세 정보</label>
                </div>
                <div class="col-lg-10">
                  <textarea
                    v-model="projectForm.DETAIL_INFO"
                    class="form-control"
                    name="textarea"
                    rows="10"
                  ></textarea>
                </div>
              </div>

            </div>

          </div>
          <hr class="mt-4">
          <b-row class="justify-content-end mr-1">
            <b-button @click="createProject" variant="primary" id="searchBtn">
              프로젝트 생성
            </b-button>
          </b-row>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { projectMethods } from '@/state/helpers'
import Swal from "sweetalert2";

export default {
  data() {
    return {
      projectForm: {
        // PROJECT_ID: '',
        PROJECT_NM: '',
        STATE: '',
        START_DT: '',
        END_DT: '',
        PERSONNEL: '',
        MEMO: '',
        IMG_PATH: '',
        LINK: '',
        DETAIL_INFO: ''
      }
    }
  },
  methods: {
    ...projectMethods,

    // Form 초기화
    initForm() {
      this.projectForm.PROJECT_ID = ''
      this.projectForm.PROJECT_NM = ''
      this.projectForm.STATE = ''
      this.projectForm.START_DT = ''
      this.projectForm.END_DT = ''
      this.projectForm.PERSONNEL = ''
      this.projectForm.MEMO = ''
      this.projectForm.IMG_PATH = ''
      this.projectForm.LINK = ''
      this.projectForm.DETAIL_INFO = ''
    },

    // 프로젝트 등록
    async createProject() {
      const result = await this.CREATE_PROJECT(this.projectForm)
      console.log(result);
      if(result.data) {
        Swal.fire("등록완료", "프로젝트가 등록되었습니다.", "success");
        this.initForm();
      }
    }

  }
}
</script>

<style scoped>
#imgComment {
  font-size: 12px;
  color: rgb(173, 173, 173);
  margin-top: 3px;
}
</style>