<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-body align-middle">
          <div class="row">

            <!-- 중요도 -->
            <div class="col-lg-1 my-auto text-right">
              <label for="" class="m-0">중요도</label>
            </div>
            <div class="col-lg-1">
              <b-form-select v-model="genderData" :options="gender"></b-form-select>
            </div>

            <!-- 카테고리 -->
            <div class="col-lg-1 my-auto text-right">
              <label for="" class="m-0">카테고리</label>
            </div>
            <div class="col-lg-1">
              <b-form-select v-model="age" :options="ageList"></b-form-select>
            </div>

            <div class="col-lg-3"></div>

            <!-- 검색 조건 -->
            <div class="col-lg-1">
              <b-form-select v-model="selected" :options="options"></b-form-select>
            </div>
            <div class="col-lg-3">
              <b-form-input v-model="searchText" placeholder="검색어를 입력하세요."></b-form-input>
            </div>

            <div class="col-lg-1">
              <b-button variant="primary" id="searchBtn">
                <i class="fas fa-search align-middle mr-2"></i>
                검색
              </b-button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 성별
      genderData: '',
      gender: [ '남자', '여자' ],

      // 나이
      age: "",
      ageList: [ '10 ~ 19', '20 ~ 29', '30 ~ 39', '40 ~ 49', '50 ~ 59' ],

      // 검색조건
      selected: '이름',
      searchText: '',
      options: [ '이름', '주소' ],

    };
  },
};
</script>
<style scoped>
.searchBox input {
  width: 212px;
}
.genderBox select {
  width: 100px;
}
.ageBox select {
  width: 100px;
}
</style>