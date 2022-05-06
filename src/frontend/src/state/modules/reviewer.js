import axios from "axios";

export const state = {
  projects: []
};

export const getters = {
  GET_PROJECTS(state) {
    return state.projects
  }
}

export const mutations = {
  SET_PROJECTS(state, projects) {
    state.projects = projects
  },
};

export const actions = {
  // eslint-disable-next-line no-unused-vars
  async CREATE_BLOGER({ commit }, param) {
    const response = await axios.post('/api/bloger', param)
    return response.data    
  },
};
