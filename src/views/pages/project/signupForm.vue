<template>
  <div id="layout-wrapper">
    <HorizontalTopbar :type="topbar" :width="layoutWidth" :headerEnable=false />
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
            <h3>{{ projectName }}</h3>
          </div>

          <!-- 프로젝트 기간 -->
          <div class="row justify-content-center mt-2">
            <div class="">
              기간 : {{ startDate }} ~ {{ endDate }}
            </div>
          </div>

          <hr>

          <!-- 상세내용 -->
          <div class="row justify-content-center my-5">
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

import { layoutComputed } from "@/state/helpers";


export default {
  name: 'signupForm',
  props: {
    projectName: {
      type: String,
      default: "",
    },
    startDate: {
      type: String,
    },
    endDate: {
      type: String,
    },
  },
  data() {
    return {
      detaitestlInfo: `*신제품으로 출시된 마운트뷰 모니터암 화이트 에디션을 체험할 수 있는 기회!

*평소 IT/리뷰/인테리어에 관심있는 분들 환영합니다 :)

1) 모집조건 및 모집인원 : IT/리뷰/인테리어에 관심있는 인플루언서 / 인스타그램 팔로워 최소 1만이상 / 50명

2) 진행 미션 : 리뷰형식 or 인테리어로 소구하여 게시물 1회 + 스토리 1회 업로드

3) 업로드 일정 : 3월 말 ~ 4월 초 예정

4) 참고사항 : 가이드 제공 후 원고 컨펌은 따로 없습니다. 요청 기한 안에 업로드 해주시면 됩니다.

5) 제공내역 : 제품 제공(3만원 상당) + 원고료 3만원`
    }
  },
  computed: {
    ...layoutComputed,
    changeDetailInfo() {
      return this.detaitestlInfo.replace(/(?:\r\n|\r|\n)/g, '<br />')
    }
  },
  components: {
    HorizontalTopbar,
  },
  methods: {
    formSubmit() {
      console.log('submit')
    }
  }
}
</script>

<style>

</style>