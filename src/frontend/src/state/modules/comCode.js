import axios from "axios";

export const state = {
  categoryList: [],
  categoryCombo: [],
};

export const getters = {
  GET_CATEGORY_LIST(state) {
    return state.categoryList
  }
}

export const mutations = {
  SET_CATEGORY_LIST(state, payload) {
    let arr = [{value: '', text: '* 카테고리 선택'}]
    payload.forEach((category) => {
      arr.push({
        value: category.categoryId,
        text: category.categoryNm,
      })
    })
    state.categoryList = payload
    state.categoryCombo = arr
  },
};

export const actions = {
  async FATCH_CATEGORY({ commit }, param) {
    const response = await axios.post('/api/findCategory', param)
    commit("SET_CATEGORY_LIST", response.data)
    return response.data
  },
  // eslint-disable-next-line no-unused-vars
  async CREATE_CATEGORY({ commit }, param) {
    const response = await axios.post('/api/category', param)
    return response.data    
  },
  // eslint-disable-next-line no-unused-vars
  async DELETE_CATEGORY({ commit }, param) {
    const response = await axios.post('/api/deleteCategory', param)
    return response.data    
  },
};
