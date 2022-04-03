<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-body align-middle">
          <div class="row">

            <!-- 검색 기간 -->
            <div class="col-lg-1 my-auto text-right">
              <label for="" class="m-0">기간</label>
            </div>
            <div class="col-lg-3">
              <date-picker v-model="daterange" range append-to-body></date-picker>
            </div>
            
            <div class="col-lg-3">
            </div>

            <!-- 검색 조건 -->
            <div class="col-lg-1">
              <b-form-select v-model="selected" :options="options"></b-form-select>
            </div>
            <div class="col-lg-2">
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
import DatePicker from "vue2-datepicker";

export default {
  components: {
    DatePicker,
  },
  data() {
    return {
      daterange: "",
      value: "",
      selected: "",
      searchText: "",
      options: [
        "제목",
        "번호",
        "태그",
      ],
    };
  },
};
</script>
<style>
.mx-input {
  height: 38px;
}
</style>