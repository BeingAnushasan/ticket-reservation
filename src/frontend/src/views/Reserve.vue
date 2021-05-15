<template>
  <div class="container" style="max-width: 800px; align-content: center">
    <div class="card bg-light" >
      <article class="card-body mx-auto" style="max-width: 600px;">

      <div class="row">
        <div class="col-12">
          <div class="login-card">
            <div>

              <div class="login-main login-form-card">
                <form class="theme-form" >
                  <h4>Reserve A Ticket</h4>
                  <p>Enter details to reserve</p>
                  <div class="form-group">

                    <div class="form-row">
                      <div class="col-6">
                        <label class="col-form-label pt-0">From</label>
                        <select
                            v-model="form.ticketInfo.source"
                            class="form-control"
                            required
                        >
                          <option value="Baglung">Baglung</option>
                          <option value="Chitwan">Chitwan</option>
                          <option value="Mustang">Mustang</option>
                          <option value="Kathmandu">Kathmandu</option>
                          <option value="Manang">Manang</option>
                          <option value="Gorkha">Gorkha</option>

                        </select>
                      </div>
                      <div class="col-6">
                        <label class="col-form-label pt-0">To</label>
                        <select
                            v-model="form.ticketInfo.destination"
                            class="form-control"
                            required
                            @change="calculatePrice"
                        >
                          <option value="Baglung">Baglung</option>
                          <option value="Chitwan">Chitwan</option>
                          <option value="Mustang">Mustang</option>
                          <option value="Kathmandu">Kathmandu</option>
                          <option value="Manang">Manang</option>
                          <option value="Gorkha">Gorkha</option>
                        </select>

                      </div>
                    </div>
                  </div>

                  <div class="form-group">
                    <label class="col-form-label">Travel Date</label>
                    <input
                        v-model="form.ticketInfo.travelDate"
                        class="form-control"
                        type="date"
                        required
                    />

                  </div>

                  <div class="form-group">
                    <div class="form-row">
                      <div class="col-6">
                    <label class="col-form-label">Departure Time</label>
                    <select
                        v-model="form.ticketInfo.pickupTime"
                        class="form-control"
                        required
                        @change="calculateArrival"
                    >
                      <option value="8 AM">8 AM</option>
                      <option value="12 PM">12 PM</option>
                      <option value="4 PM">4 PM</option>
                      <option value="8 PM">8 PM</option>
                    </select>
                      </div>
                      <div class="col-6">
                        <label class="col-form-label">Arrival Time</label>
                        <h3
                        >
                          {{form.ticketInfo.arrivalTime}}
                        </h3>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-form-label">Total Amount</label>
                    <h3
                    >
                      Rs {{form.ticketInfo.price}}
                    </h3>

                  </div>
                  <div class="form-group mb-0">
                    <div class="checkbox p-0">
                      <input id="checkbox1" type="checkbox" />
                      <label class="text-muted" for="checkbox1"
                      >Agree with<a class="ml-2" href="#"
                      >Privacy Policy</a
                      ></label
                      >
                    </div>
                    <button
                        class="btn btn-primary btn-block"
                        type="submit"
                        @click="submit($event)"

                    >
                      <b-spinner small type="grow" v-if="isLoading"></b-spinner>

                      Pay & Reserve
                    </button>
                  </div>
                  <p class="mt-4 mb-0">
                    Already have an account?
                    <router-link class="ml-2" tag="a" to="/auth/login">
                      Login
                    </router-link>
                  </p>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
      </article>
    </div>
  </div>
</template>
<script>
import API from "@/resources/API";
export default {
  name: "register",
  data() {
    return {
      form: {
        ticketInfo: {
          source: "",
          destination: "",
          travelDate: "",
          pickupTime: "",
          arrivalTime: "",
          price: "0",
          reservedDate:new Date()
        },
        paymentInfo: {
          accountNo: "n/a",
          cardType: "DEBIT",
          paidDate: new Date()
        }
      },
      type: "",
      isFormValidated: null,
      submitted: false,
      isLoading: false,
    };
  },

  methods: {
    calculateArrival() {
      return this.form.ticketInfo.arrivalTime = ((+this.form.ticketInfo.pickupTime.split(/ (.*)/)[0]+3)%12)+" "+this.form.ticketInfo.pickupTime.split(/ (.*)/)[1];
    },
    calculatePrice() {
      this.form.ticketInfo.price = (Math.floor(Math.random() * (10000 - 3000) ) + 3000);
      return this.form.ticketInfo.price;
    },

    submit(e){
      e.preventDefault();
      console.log(this.form);
      API.makeReservation(this.form).then((res)=>{
        console.log(res.data.status);
        alert(res.data.status);
        this.$router.push("/dashboard")
      })
    }
  }
}
</script>
