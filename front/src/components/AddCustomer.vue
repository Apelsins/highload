<template>
  <div>
    <div v-if="!submitted">
      <div class="mb-3">
        <label for="login" class="form-label">Login</label>
        <input
          type="text"
          class="form-control"
          id="login"
          required
          name="login"
          v-model="customer.login"
        />
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input
          type="text"
          class="form-control"
          id="password"
          required
          name="password"
          v-model="customer.password"
        />
      </div>
      <div class="mb-3">
        <label for="firstName" class="form-label">First Name</label>
        <input
          type="text"
          class="form-control"
          id="firstName"
          required
          name="firstName"
          v-model="customer.firstName"
        />
      </div>
      <div class="mb-3">
        <label for="lastName" class="form-label">Last Name</label>
        <input
          type="text"
          class="form-control"
          id="lastName"
          required
          name="lastName"
          v-model="customer.lastName"
        />
      </div>
      <div class="mb-3">
        <label for="age" class="form-label">Age</label>
        <input
          type="number"
          class="form-control"
          id="age"
          required
          name="age"
          v-model="customer.age"
        />
      </div>
      <div class="mb-3">
        <label for="gender" class="form-label">Gender</label>
        <input
          type="text"
          class="form-control"
          id="gender"
          required
          name="gender"
          v-model="customer.gender"
        />
      </div>
      <div class="mb-3">
        <label for="city" class="form-label">City</label>
        <input
          type="text"
          class="form-control"
          id="city"
          required
          name="city"
          v-model="customer.city"
        />
      </div>
      <div class="mb-3">
        <button @click="saveCustomer" class="btn btn-primary">Submit</button>
      </div>
    </div>
    <div v-else>
      <div class="alert alert-success" role="alert">
        Save customer successfully!
      </div>
      <button @click="newCustomer" class="btn btn-primary">
        Add New Customer
      </button>
    </div>
  </div>
</template>

<script>
import CustomerDataService from "../services/CustomerDataService";

export default {
  name: "add-customer",
  data() {
    return {
      customer: {
        id: null,
        login: "login1",
        password: "login1",
        firstName: "Alex",
        lastName: "Tokop",
        age: 23,
        gender: "MALE",
        city: "Moscow",
      },
      submitted: false,
    };
  },
  methods: {
    saveCustomer() {
      var data = {
        login: this.customer.login,
        password: this.customer.password,
        firstName: this.customer.firstName,
        lastName: this.customer.lastName,
        age: this.customer.age,
        gender: this.customer.gender,
        city: this.customer.city,
      };
      CustomerDataService.create(data)
        .then((response) => {
          this.customer.id = response.data.id;
          this.submitted = true;
        })
        .catch((e) => {
          alert(e);
        });
    },
    newCustomer() {
      this.submitted = false;
      this.customer = {};
    },
  },
};
</script>
