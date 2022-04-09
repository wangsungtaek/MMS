<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-body align-middle">
          <div class="row">

            <div class="col-lg-7">
            </div>

            <!-- 검색 조건 -->
            <div class="col-lg-1">
              <b-form-select v-model="selected" :options="options"></b-form-select>
            </div>
            <div class="col-lg-2 searchBox">
              <b-form-input v-model="searchText" placeholder="검색어를 입력하세요."></b-form-input>
            </div>

            <div class="col-lg-2">
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
      // 검색조건
      selected: '전체',
      searchText: '',
      options: [ '전체', '네이버', '인스타'],

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