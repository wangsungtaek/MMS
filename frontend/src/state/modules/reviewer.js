import axios from "axios";

export const state = {
  blogerList: []
};

export const getters = {
  GET_BLOGER_LIST(state) {
    return state.blogerList
  }
}

export const mutations = {
  SET_BLOGER_LIST(state, payload) {
    state.blogerList = payload
  },
};

export const actions = {
  async FATCH_REVIEWER({ commit }, param) {
    const response = await axios.post('/api/findBloger', param)
    commit("SET_BLOGER_LIST", response.data)
    return response.data
  },
  // eslint-disable-next-line no-unused-vars
  async CREATE_REVIEWER({ commit }, param) {
    const response = await axios.post('/api/bloger', param)
    return response.data    
  },
  // eslint-disable-next-line no-unused-vars
  async UPDATE_REVIEWER({ commit }, param) {
    const response = await axios.patch('/api/bloger', param)
    return response.data    
  },
  // eslint-disable-next-line no-unused-vars
  async DELETE_REVIEWER({ commit }, param) {
    const response = await axios.post('/api/deleteBloger', param)
    return response.data    
  },
};
