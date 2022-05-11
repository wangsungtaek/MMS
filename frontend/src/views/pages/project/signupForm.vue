<template>
  <div id="layout-wrapper">
    <HorizontalTopbar :headerEnable=false />
    <div class="main-content">
      <div class="page-content">
        <div class="container-fluid">

          <!-- 대표 이미지 -->
          <div class="row justify-content-center">
            <img
              class="rounded-circle avatar-xl"
              alt="200x200"
              src="@/assets/images/users/avatar-4.jpg"
              data-holder-rendered="true"
            />
          </div>

          <!-- 프로젝트 제목 -->
          <div class="row justify-content-center mt-5">
            <h3>{{ this.projects[0] ? this.projects[0].PROJECT_NM : '' }}</h3>
          </div>

          <!-- 프로젝트 기간 -->
          <div class="row justify-content-center mt-2">
            <div class="">
              기간 : {{ this.projects[0] ? startDate : '' }} ~ {{ this.projects[0] ? endDate : ''}}
            </div>
          </div>

          <hr>

          <!-- 상세내용 -->
          <div class="row justify-content-center my-5" v-if="this.projects[0]">
            <div v-html="changeDetailInfo">
              
            </div>
          </div>
          
          <hr>
          <div class="row justify-content-center">
            <h4>신청서</h4>
          </div>

          <div class="row justify-content-center">
            <div class="col-6">
            <form class="form-horizontal" role="form" @submit.prevent="formSubmit">

              <!-- 성함 -->
              <b-form-group
                label-cols-sm="2"
                label-cols-lg="2"
                label="성함"
                label-for="text"
                class="mt-2"
              >
                <b-form-input for="text" placeholder="홍길동"></b-form-input>
              </b-form-group>

              <!-- 연락처 -->
              <b-form-group
                label-cols-sm="2"
                label-cols-lg="2"
                label="연락처"
                label-for="text"
                class="mt-3"
              >
                <b-form-input for="text" placeholder="01022223333"></b-form-input>
                <span>신청시 해당 연락처로 연락드립니다.</span>
              </b-form-group>

              <!-- 이메일 -->
              <b-form-group
                label-cols-sm="2"
                label-cols-lg="2"
                label="이메일"
                label-for="email"
              >
                <b-form-input id="email" placeholder="email@example.com"></b-form-input>
              </b-form-group>

              <div class="text-right">
                <button class="btn btn-success" type="submit">NAVER 계정으로 신청하기</button>
                <button class="btn btn-danger ml-2" type="submit">Instagram 계정으로 신청하기</button>
              </div>
            </form>
            </div>
          </div>

        </div>

      </div>
    </div>
  </div>
</template>

<script>
import HorizontalTopbar from "@/components/horizontal-topbar";
import { projectComputed ,projectMethods } from '@/state/helpers'


export default {
  name: 'signupForm',
  
  computed: {
    ...projectComputed,
    changeDetailInfo() {
      return this.projects[0].DETAIL_INFO.replace(/(?:\r\n|\r|\n)/g, '<br />')
    },
    startDate() {
      return this.projects[0].START_DT.substring(0, 10)
    },
    endDate() {
      return this.projects[0].END_DT.substring(0, 10)
    },
  },
  components: {
    HorizontalTopbar,
  },
  methods: {
    ...projectMethods,
    formSubmit() {
      console.log('submit')
    }
  },
  created() {
    this.FETCH_PROJECT(this.$route.params)
    console.log(this.projects[0])
  }
}
</script>

<style>

</style>