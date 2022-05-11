<template>
  <b-button
    class="mr-1"
    :variant="color"
    v-b-tooltip.hover
    :title="label"
    size="sm"
    @click="onButton"
  >
    <i class="mdi font-size-15" :class="icon"></i>
  </b-button>
</template>

<script>
export default {
  props: {
    label: { default: '' },
    color: { default: 'primary' },
    icon: { default: 'mdi-pencil' }
  },

  methods: {
    onButton() {
      this.$emit('buttonON')
    }
  }
}
</script>

<style>

</style>