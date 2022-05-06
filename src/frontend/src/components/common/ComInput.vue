<template>
<div class="form-group">

  <!-- input -->
  <input 
    v-if="type == 'text' || type == 'number' || type == 'email'"
    class="form-control"
    v-model="value"
    :type="type"
    :placeholder="title"/>

  <!-- textarea -->
  <textarea
    v-if="type == 'textarea'"
    class="form-control"
    v-model="value"
    rows="3"
    :placeholder="title"/>

  <!-- select -->
  <b-form-select 
    v-if="type == 'select'"
    v-model="value"
    :options="items" />

</div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      default: '',
    },
    type: {
      type: String,
      default: 'text'
    },
    items: {
      type: Array,
      default: null
    }
  },
  computed: {
    value: {
      get() {
        return this.$attrs.value;
      },
      set(newValue) {
        this.onDataChanged(newValue);
      },
    },
  },
  methods: {
    onDataChanged(value) {
      this.$emit('input', value)
    }
  }
}
</script>

<style>

</style>