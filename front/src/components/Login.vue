<template>
  <div class="container mt-5">
    <div class="row d-flex justify-content-center">
      <div class="col-md-6">
        <div class="card px-5 py-5" id="form1">
          <div class="form-data" v-if="!submitted">
            <div class="forms-inputs mb-4">
              <span>Login</span>
              <input
                autocomplete="off"
                type="text"
                v-model="login"
                v-bind:class="{
                  'form-control': true,
                }"
              />
            </div>
            <div class="forms-inputs mb-4">
              <span>Password</span>
              <input
                autocomplete="off"
                type="password"
                v-model="password"
                v-bind:class="{
                  'form-control': true,
                }"
              />
            </div>
            <div class="mb-3">
              <button
                v-on:click.stop.prevent="submit"
                class="btn btn-dark w-100"
              >
                Login
              </button>
            </div>
          </div>
          <div class="success-data" v-else>
            <div class="text-center d-flex flex-column">
              <i class="bx bxs-badge-check"></i>
              <span class="text-center fs-1"
                >You have been logged in <br />
                Successfully</span
              >
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import CustomerDataService from "../services/CustomerDataService";

export default {
  name: "login",
  data() {
    return {
      login: "",
      valid: false,
      password: "",
      submitted: false,
    };
  },

  methods: {
    validate: function () {
      this.passwordBlured = true;
      this.valid = true;
    },

    submit: function () {
      this.validate();
      if (this.valid) {
        this.submitted = true;
      }
    },
  },
};
</script>