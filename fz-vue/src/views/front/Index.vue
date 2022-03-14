<template>
  <div>
    <section id="hero">
      <div class="container">
        <div style="height: 20px; width: 100%"></div>
        <ul>
          <li><a href="#portfolio">潮牌服饰</a></li>
          <li><a href="#team">简约舒适</a></li>
          <li><a href="#services">运动服饰</a></li>
          <li><a href="#nation">国风潮流</a></li>
          <li><a href="#">其他</a></li>
        </ul>
        <div class="container-text">
          <h1>Welcome to F & C</h1>
          <h2>We are committed to the high quality of clothing brands</h2>
          <!-- <a href="#about" class="btn-get-started scrollto">Get Started</a> -->
        </div>
      </div>
    </section>

    <main id="main">
      <!-- ======= Clients Section ======= -->
      <section id="clients" class="clients section-bg">
        <div class="container">
          <div class="row">
            <div
              class="
                col-lg-2 col-md-4 col-6
                d-flex
                align-items-center
                justify-content-center
              "
            >
              <img
                src="../../assets/img/clients/auto-1.jpg"
                class="img-fluid"
                alt=""
              />
            </div>

            <div
              class="
                col-lg-2 col-md-4 col-6
                d-flex
                align-items-center
                justify-content-center
              "
            >
              <img
                src="../../assets/img/clients/client-2.png"
                class="img-fluid"
                alt=""
              />
            </div>

            <div
              class="
                col-lg-2 col-md-4 col-6
                d-flex
                align-items-center
                justify-content-center
              "
            >
              <img
                src="../../assets/img/clients/client-3.png"
                class="img-fluid"
                alt=""
              />
            </div>

            <div
              class="
                col-lg-2 col-md-4 col-6
                d-flex
                align-items-center
                justify-content-center
              "
            >
              <img
                src="../../assets/img/clients/client-4.png"
                class="img-fluid"
                alt=""
              />
            </div>

            <div
              class="
                col-lg-2 col-md-4 col-6
                d-flex
                align-items-center
                justify-content-center
              "
            >
              <img
                src="../../assets/img/clients/client-5.png"
                class="img-fluid"
                alt=""
              />
            </div>

            <div
              class="
                col-lg-2 col-md-4 col-6
                d-flex
                align-items-center
                justify-content-center
              "
            >
              <img
                src="../../assets/img/clients/client-6.png"
                class="img-fluid"
                alt=""
              />
            </div>
          </div>
        </div>
      </section>

      <section id="portfolio" class="portfolio">
        <div class="container">
          <div class="section-title">
            <h2>潮牌服饰</h2>
            <p>不追求过高的价格和太过奢侈的享受，仅看质量和款式!</p>
            <p>相信您的眼睛，尊尚给您不一样的时尚</p>
          </div>

          <div class="row">
            <div class="col-lg-12 d-flex justify-content-center">
              <ul id="portfolio-flters">
                <li data-filter="*" class="filter-active">所有</li>
                <li data-filter=".filter-app">男生</li>
                <li data-filter=".filter-card">女生</li>
                <li data-filter=".filter-web">儿童</li>
              </ul>
            </div>
          </div>

          <div class="row portfolio-container">
            <div
              class="col-lg-4 col-md-6 portfolio-item filter-app"
              v-for="tideGood in tideGoods"
              :key="tideGood.id"
            >
              <img :src="tideGood.pic" class="img-fluid" alt="" />
              <div class="portfolio-info">
                <h4>{{ tideGood.name }}</h4>
                <p>￥{{ tideGood.price }}元</p>
                <a
                  href="tideGood.pic"
                  data-gall="portfolioGallery"
                  class="venobox preview-link"
                  title="App 1"
                  ><i class="bx bx-plus"></i
                ></a>
                <a
                  href="javascript: void(0);"
                  data-gall="portfolioDetailsGallery"
                  data-vbtype="iframe"
                  class="venobox details-link"
                  title="Portfolio Details"
                  @click="handleGoodsInfo(tideGood.id)"
                  ><i class="bx bx-link"></i
                ></a>
              </div>
            </div>

            <!-- <div class="col-lg-4 col-md-6 portfolio-item filter-web">
              <img
                src="../../assets/img/portfolio/portfolio-2.jpg"
                class="img-fluid"
                alt=""
              />
              <div class="portfolio-info">
                <h4>Web 3</h4>
                <p>Web</p>
                <a
                  href="../../assets/img/portfolio/portfolio-2.jpg"
                  data-gall="portfolioGallery"
                  class="venobox preview-link"
                  title="Web 3"
                  ><i class="bx bx-plus"></i
                ></a>
                <a
                  href="/goodsDetail"
                  data-gall="portfolioDetailsGallery"
                  data-vbtype="iframe"
                  class="venobox details-link"
                  title="Portfolio Details"
                  ><i class="bx bx-link"></i
                ></a>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 portfolio-item filter-app">
              <img
                src="../../assets/img/portfolio/portfolio-3.jpg"
                class="img-fluid"
                alt=""
              />
              <div class="portfolio-info">
                <h4>App 2</h4>
                <p>App</p>
                <a
                  href="../../assets/img/portfolio/portfolio-3.jpg"
                  data-gall="portfolioGallery"
                  class="venobox preview-link"
                  title="App 2"
                  ><i class="bx bx-plus"></i
                ></a>
                <a
                  href="/goodsDetail"
                  data-gall="portfolioDetailsGallery"
                  data-vbtype="iframe"
                  class="venobox details-link"
                  title="Portfolio Details"
                  ><i class="bx bx-link"></i
                ></a>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 portfolio-item filter-card">
              <img
                src="../../assets/img/portfolio/portfolio-4.jpg"
                class="img-fluid"
                alt=""
              />
              <div class="portfolio-info">
                <h4>Card 2</h4>
                <p>Card</p>
                <a
                  href="../../assets/img/portfolio/portfolio-4.jpg"
                  data-gall="portfolioGallery"
                  class="venobox preview-link"
                  title="Card 2"
                  ><i class="bx bx-plus"></i
                ></a>
                <a
                  href="/goodsDetail"
                  data-gall="portfolioDetailsGallery"
                  data-vbtype="iframe"
                  class="venobox details-link"
                  title="Portfolio Details"
                  ><i class="bx bx-link"></i
                ></a>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 portfolio-item filter-web">
              <img
                src="../../assets/img/portfolio/portfolio-5.jpg"
                class="img-fluid"
                alt=""
              />
              <div class="portfolio-info">
                <h4>Web 2</h4>
                <p>Web</p>
                <a
                  href="../../assets/img/portfolio/portfolio-5.jpg"
                  data-gall="portfolioGallery"
                  class="venobox preview-link"
                  title="Web 2"
                  ><i class="bx bx-plus"></i
                ></a>
                <a
                  href="/goodsDetail"
                  data-gall="portfolioDetailsGallery"
                  data-vbtype="iframe"
                  class="venobox details-link"
                  title="Portfolio Details"
                  ><i class="bx bx-link"></i
                ></a>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 portfolio-item filter-app">
              <img
                src="../../assets/img/portfolio/portfolio-6.jpg"
                class="img-fluid"
                alt=""
              />
              <div class="portfolio-info">
                <h4>App 3</h4>
                <p>App</p>
                <a
                  href="../../assets/img/portfolio/portfolio-6.jpg"
                  data-gall="portfolioGallery"
                  class="venobox preview-link"
                  title="App 3"
                  ><i class="bx bx-plus"></i
                ></a>
                <a
                  href="/goodsDetail"
                  data-gall="portfolioDetailsGallery"
                  data-vbtype="iframe"
                  class="venobox details-link"
                  title="Portfolio Details"
                  ><i class="bx bx-link"></i
                ></a>
              </div>
            </div> -->
          </div>
        </div>
      </section>

      <section id="team" class="team section-bg">
        <div class="container">
          <div class="section-title">
            <h2>简约舒适</h2>
            <p>
              时尚是具有很强的包容性，所以使得穿衣风格也越来越多样化。但万变不离其宗，舒适简约的穿搭经典又时尚也是大家所追求的。那么在日常生活中舒适的简约风该如何打造呢，才可以让你更时尚惊艳。
            </p>
          </div>

          <div class="row">
            <div
              class="col-lg-3 col-md-6 d-flex align-items-stretch"
              v-for="simpleGood in simpleGoods"
              :key="simpleGood.id"
            >
              <div class="member">
                <div class="member-img simpleImg-size">
                  <img :src="simpleGood.pic" class="img-fluid" alt="" />
                  <div class="social">
                    <a href=""><i class="el-icon-share"></i></a>
                    <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                    <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                  </div>
                </div>
                <div class="member-info row">
                  <div class="col-lg-8 col-md-8 col-12">
                    <h5>{{ simpleGood.name }}</h5>
                    <span>￥{{ simpleGood.price }}元</span>
                    <el-tag type="danger" size="mini" style="width: 40px"
                      >包邮</el-tag
                    >
                  </div>
                  <div class="col-lg-4 col-md-4 col-12">
                    <button class="simple-button">购买</button>
                  </div>
                </div>
              </div>
            </div>

            <!-- <div class="col-lg-3 col-md-6 d-flex align-items-stretch">
              <div class="member">
                <div class="member-img">
                  <img
                    src="../../assets/img/team/team-2.jpg"
                    class="img-fluid"
                    alt=""
                  />
                  <div class="social">
                    <a href=""><i class="el-icon-share"></i></a>
                    <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                    <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                  </div>
                </div>
                <div class="member-info">
                  <h4>Sarah Jhonson</h4>
                  <span>Product Manager</span>
                </div>
              </div>
            </div>

            <div class="col-lg-3 col-md-6 d-flex align-items-stretch">
              <div class="member">
                <div class="member-img">
                  <img
                    src="../../assets/img/team/team-3.jpg"
                    class="img-fluid"
                    alt=""
                  />
                  <div class="social">
                    <a href=""><i class="el-icon-share"></i></a>
                    <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                    <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                  </div>
                </div>
                <div class="member-info">
                  <h4>William Anderson</h4>
                  <span>CTO</span>
                </div>
              </div>
            </div>

            <div class="col-lg-3 col-md-6 d-flex align-items-stretch">
              <div class="member">
                <div class="member-img">
                  <img
                    src="../../assets/img/team/team-4.jpg"
                    class="img-fluid"
                    alt=""
                  />
                  <div class="social">
                    <a href=""><i class="el-icon-share"></i></a>
                    <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                    <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                  </div>
                </div>
                <div class="member-info">
                  <h4>Amanda Jepson</h4>
                  <span>Accountant</span>
                </div>
              </div>
            </div> -->
          </div>
        </div>
      </section>

      <section id="services" class="services">
        <div class="container">
          <div class="row">
            <div class="col-lg-4">
              <img
                src="../../assets/img/sport-1.jpg"
                style="height: 680px"
                class="img-fluid"
                alt=""
              />
            </div>
            <div class="col-lg-8 pt-4 pt-lg-0">
              <div class="section-title">
                <h2>运动服饰</h2>
                <p>
                  C &
                  F一个中高档运动休闲服品牌，特征集一句吸引人的运动装的宣传语，要求作品主要体现其运动的普遍性及大众化，能贴切消费群体，体现运动，体现我们正在不懈的进取，把品牌做好、做大，要让人觉得亲昵、喜欢，要简单明了，朗朗上口，易于记忆
                </p>
              </div>
              <div class="container">
                <div class="row">
                  <div
                    class="col-lg-4 col-md-6"
                    v-for="sportGood in sportGoods"
                    :key="sportGood.id"
                  >
                    <a href="/goodsDetail"
                      ><img :src="sportGood.pic" class="img-fluid" alt=""
                    /></a>
                    <div class="sport-info">
                      <h6>{{ sportGood.name }}</h6>
                      <p>￥{{ sportGood.price }}元</p>
                      <div>
                        <el-tag type="success" size="mini">包邮</el-tag>
                        <button class="shopping-cart-button">加入购物车</button>
                        <button class="sport-button">购买</button>
                      </div>
                    </div>
                  </div>

                  <!-- <div
                    class="col-lg-4 col-md-6"
                    v-for="tideGood in tideGoods"
                    :key="tideGood.id"
                  >
                    <a href="/goodsDetail"
                      ><img :src="tideGood.goodImg" class="img-fluid" alt=""
                    /></a>
                    <div class="sport-info">
                      <h6>{{ tideGood.goodName }}</h6>
                      <p>￥{{ tideGood.goodPrice }}元</p>
                      <div>
                        <el-tag type="success" size="mini">包邮</el-tag>
                        <button class="shopping-cart-button">加入购物车</button>
                        <button class="sport-button">购买</button>
                      </div>
                    </div>
                  </div>
                  <div
                    class="col-lg-4 col-md-6"
                    v-for="tideGood in tideGoods"
                    :key="tideGood.id"
                  >
                    <a href="/goodsDetail"
                      ><img :src="tideGood.goodImg" class="img-fluid" alt=""
                    /></a>
                    <div class="sport-info">
                      <h6>{{ tideGood.goodName }}</h6>
                      <p>￥{{ tideGood.goodPrice }}元</p>
                      <div>
                        <el-tag type="success" size="mini">包邮</el-tag>
                        <button class="shopping-cart-button">加入购物车</button>
                        <button class="sport-button">购买</button>
                      </div>
                    </div>
                  </div>
                  <div
                    class="col-lg-4 col-md-6"
                    v-for="tideGood in tideGoods"
                    :key="tideGood.id"
                  >
                    <a href="/goodsDetail"
                      ><img :src="tideGood.goodImg" class="img-fluid" alt=""
                    /></a>
                    <div class="sport-info">
                      <h6>{{ tideGood.goodName }}</h6>
                      <p>￥{{ tideGood.goodPrice }}元</p>
                      <div>
                        <el-tag type="success" size="mini">包邮</el-tag>
                        <button class="shopping-cart-button">加入购物车</button>
                        <button class="sport-button">购买</button>
                      </div>
                    </div>
                  </div>
                  <div
                    class="col-lg-4 col-md-6"
                    v-for="tideGood in tideGoods"
                    :key="tideGood.id"
                  >
                    <a href="/goodsDetail"
                      ><img :src="tideGood.goodImg" class="img-fluid" alt=""
                    /></a>
                    <div class="sport-info">
                      <h6>{{ tideGood.goodName }}</h6>
                      <p>￥{{ tideGood.goodPrice }}元</p>
                      <div>
                        <el-tag type="success" size="mini">包邮</el-tag>
                        <button class="shopping-cart-button">加入购物车</button>
                        <button class="sport-button">购买</button>
                      </div>
                    </div>
                  </div>
                  <div
                    class="col-lg-4 col-md-6"
                    v-for="tideGood in tideGoods"
                    :key="tideGood.id"
                  >
                    <a href="/goodsDetail"
                      ><img :src="tideGood.goodImg" class="img-fluid" alt=""
                    /></a>
                    <div class="sport-info">
                      <h6>{{ tideGood.goodName }}</h6>
                      <p>￥{{ tideGood.goodPrice }}元</p>
                      <div>
                        <el-tag type="success" size="mini">包邮</el-tag>
                        <button class="shopping-cart-button">加入购物车</button>
                        <button class="sport-button">购买</button>
                      </div>
                    </div>
                  </div> -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <section id="nation">
        <section id="team" class="team section-bg">
          <div class="container">
            <div class="section-title">
              <h2>国风潮流</h2>
              <p>
                “国潮”从字面来看意为“
                国风＋潮流”，其以中国文化和传统为基础，集腔调、时尚与格调于一身，是传统与现代的碰撞，更是东方美学的淋漓展现
              </p>
            </div>

            <div class="row">
              <div
                class="col-lg-3 col-md-6 d-flex align-items-stretch"
                v-for="nationGood in nationGoods"
                :key="nationGood.id"
              >
                <div class="member" style="height: 290px">
                  <div class="member-img">
                    <img
                      :src="nationGood.pic"
                      class="img-fluid nationalImg-size"
                      alt=""
                    />
                    <div class="social">
                      <a href=""><i class="el-icon-share"></i></a>
                      <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                      <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                    </div>
                  </div>
                  <div class="member-info row">
                    <div class="col-lg-8 col-md-8 col-12">
                      <h5>{{ nationGood.name }}</h5>
                      <span>￥{{ nationGood.price }}元</span>
                      <el-tag type="warning" size="mini" style="width: 40px"
                        >包邮</el-tag
                      >
                    </div>
                    <div class="col-lg-4 col-md-4 col-12">
                      <button class="simple-button">购 买</button>
                    </div>
                  </div>
                </div>
              </div>

              <!-- <div
                class="col-lg-3 col-md-6 d-flex align-items-stretch"
                v-for="simpleGood in simpleGoods"
                :key="simpleGood.id"
              >
                <div class="member" style="height: 290px">
                  <div class="member-img">
                    <img
                      :src="simpleGood.goodImg"
                      class="img-fluid nationalImg-size"
                      alt=""
                    />
                    <div class="social">
                      <a href=""><i class="el-icon-share"></i></a>
                      <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                      <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                    </div>
                  </div>
                  <div class="member-info row">
                    <div class="col-lg-8 col-md-8 col-12">
                      <h5>{{ simpleGood.goodName }}</h5>
                      <span>￥{{ simpleGood.goodPrice }}元</span>
                      <el-tag type="warning" size="mini" style="width: 40px"
                        >包邮</el-tag
                      >
                    </div>
                    <div class="col-lg-4 col-md-4 col-12">
                      <button class="simple-button">购 买</button>
                    </div>
                  </div>
                </div>
              </div>
              <div
                class="col-lg-3 col-md-6 d-flex align-items-stretch"
                v-for="simpleGood in simpleGoods"
                :key="simpleGood.id"
              >
                <div class="member" style="height: 290px">
                  <div class="member-img">
                    <img
                      :src="simpleGood.goodImg"
                      class="img-fluid nationalImg-size"
                      alt=""
                    />
                    <div class="social">
                      <a href=""><i class="el-icon-share"></i></a>
                      <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                      <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                    </div>
                  </div>
                  <div class="member-info row">
                    <div class="col-lg-8 col-md-8 col-12">
                      <h5>{{ simpleGood.goodName }}</h5>
                      <span>￥{{ simpleGood.goodPrice }}元</span>
                      <el-tag type="warning" size="mini" style="width: 40px"
                        >包邮</el-tag
                      >
                    </div>
                    <div class="col-lg-4 col-md-4 col-12">
                      <button class="simple-button">购 买</button>
                    </div>
                  </div>
                </div>
              </div>
              <div
                class="col-lg-3 col-md-6 d-flex align-items-stretch"
                v-for="simpleGood in simpleGoods"
                :key="simpleGood.id"
              >
                <div class="member" style="height: 290px">
                  <div class="member-img">
                    <img
                      :src="simpleGood.goodImg"
                      class="img-fluid nationalImg-size"
                      alt=""
                    />
                    <div class="social">
                      <a href=""><i class="el-icon-share"></i></a>
                      <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                      <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                    </div>
                  </div>
                  <div class="member-info row">
                    <div class="col-lg-8 col-md-8 col-12">
                      <h5>{{ simpleGood.goodName }}</h5>
                      <span>￥{{ simpleGood.goodPrice }}元</span>
                      <el-tag type="warning" size="mini" style="width: 40px"
                        >包邮</el-tag
                      >
                    </div>
                    <div class="col-lg-4 col-md-4 col-12">
                      <button class="simple-button">购 买</button>
                    </div>
                  </div>
                </div>
              </div>
              <div
                class="col-lg-3 col-md-6 d-flex align-items-stretch"
                v-for="simpleGood in simpleGoods"
                :key="simpleGood.id"
              >
                <div class="member" style="height: 290px">
                  <div class="member-img">
                    <img
                      :src="simpleGood.goodImg"
                      class="img-fluid nationalImg-size"
                      alt=""
                    />
                    <div class="social">
                      <a href=""><i class="el-icon-share"></i></a>
                      <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                      <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                    </div>
                  </div>
                  <div class="member-info row">
                    <div class="col-lg-8 col-md-8 col-12">
                      <h5>{{ simpleGood.goodName }}</h5>
                      <span>￥{{ simpleGood.goodPrice }}元</span>
                      <el-tag type="warning" size="mini" style="width: 40px"
                        >包邮</el-tag
                      >
                    </div>
                    <div class="col-lg-4 col-md-4 col-12">
                      <button class="simple-button">购 买</button>
                    </div>
                  </div>
                </div>
              </div>
              <div
                class="col-lg-3 col-md-6 d-flex align-items-stretch"
                v-for="simpleGood in simpleGoods"
                :key="simpleGood.id"
              >
                <div class="member" style="height: 290px">
                  <div class="member-img">
                    <img
                      :src="simpleGood.goodImg"
                      class="img-fluid nationalImg-size"
                      alt=""
                    />
                    <div class="social">
                      <a href=""><i class="el-icon-share"></i></a>
                      <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                      <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                    </div>
                  </div>
                  <div class="member-info row">
                    <div class="col-lg-8 col-md-8 col-12">
                      <h5>{{ simpleGood.goodName }}</h5>
                      <span>￥{{ simpleGood.goodPrice }}元</span>
                      <el-tag type="warning" size="mini" style="width: 40px"
                        >包邮</el-tag
                      >
                    </div>
                    <div class="col-lg-4 col-md-4 col-12">
                      <button class="simple-button">购 买</button>
                    </div>
                  </div>
                </div>
              </div>
              <div
                class="col-lg-3 col-md-6 d-flex align-items-stretch"
                v-for="simpleGood in simpleGoods"
                :key="simpleGood.id"
              >
                <div class="member" style="height: 290px">
                  <div class="member-img">
                    <img
                      :src="simpleGood.goodImg"
                      class="img-fluid nationalImg-size"
                      alt=""
                    />
                    <div class="social">
                      <a href=""><i class="el-icon-share"></i></a>
                      <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                      <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                    </div>
                  </div>
                  <div class="member-info row">
                    <div class="col-lg-8 col-md-8 col-12">
                      <h5>{{ simpleGood.goodName }}</h5>
                      <span>￥{{ simpleGood.goodPrice }}元</span>
                      <el-tag type="warning" size="mini" style="width: 40px"
                        >包邮</el-tag
                      >
                    </div>
                    <div class="col-lg-4 col-md-4 col-12">
                      <button class="simple-button">购 买</button>
                    </div>
                  </div>
                </div>
              </div>
              <div
                class="col-lg-3 col-md-6 d-flex align-items-stretch"
                v-for="simpleGood in simpleGoods"
                :key="simpleGood.id"
              >
                <div class="member" style="height: 290px">
                  <div class="member-img">
                    <img
                      :src="simpleGood.goodImg"
                      class="img-fluid nationalImg-size"
                      alt=""
                    />
                    <div class="social">
                      <a href=""><i class="el-icon-share"></i></a>
                      <a href="/goodsDetail"><i class="el-icon-s-goods"></i></a>
                      <a href=""><i class="el-icon-shopping-cart-2"></i></a>
                    </div>
                  </div>
                  <div class="member-info row">
                    <div class="col-lg-8 col-md-8 col-12">
                      <h5>{{ simpleGood.goodName }}</h5>
                      <span>￥{{ simpleGood.goodPrice }}元</span>
                      <el-tag type="warning" size="mini" style="width: 40px"
                        >包邮</el-tag
                      >
                    </div>
                    <div class="col-lg-4 col-md-4 col-12">
                      <button class="simple-button">购 买</button>
                    </div>
                  </div>
                </div>
              </div> -->
            </div>
          </div>
        </section>
      </section>

      <footer id="footer">
        <div class="container d-md-flex py-4">
          <div class="mr-md-auto text-center text-md-left">
            <div class="copyright">
              Copyright &copy; 2021.School name Sun Yat Sen college, University
              of Electronic Science and technology
            </div>
            <div class="credits"></div>
          </div>
          <div class="social-links text-center text-md-right pt-3 pt-md-0">
            <el-button type="info" icon="el-icon-share" circle></el-button>
            <el-button type="info" icon="el-icon-s-goods" circle></el-button>
            <el-button type="info" icon="el-icon-s-custom" circle></el-button>
            <el-button
              type="info"
              icon="el-icon-shopping-cart-full"
              circle
            ></el-button>
            <el-button type="info" icon="el-icon-message" circle></el-button>
          </div>
        </div>
      </footer>
    </main>
  </div>
</template>

<script>
// import Header from '../components/Header.vue'
import { fetchTideList } from "@/api/clothing";
export default {
  name: "Index",
  data() {
    return {
      tideGoods: [],
      simpleGoods: [],
      sportGoods: [],
      nationGoods: [],
      listTideQuery: {
        keyword: null,
        pageNum: 1,
        pageSize: 6,
      },
      listSimpleQuery: {
        keyword: null,
        pageNum: 1,
        pageSize: 4,
      },
      listSportQuery: {
        keyword: null,
        pageNum: 1,
        pageSize: 6,
      },
      listNationQuery: {
        keyword: null,
        pageNum: 1,
        pageSize: 8,
      },
    };
  },
  components: {
    "remote-js": {
      render(createElement) {
        return createElement("script", {
          attrs: {
            type: "text/JavaScript",
            src: "../../assets/js/main.js",
          },
        });
      },
    },
    "remote-js": {
      render(createElement) {
        return createElement("script", {
          attrs: {
            type: "text/JavaScript",
            src: "../../assets/vendor/jquery/jquery.min.js",
          },
        });
      },
    },
    "remote-js": {
      render(createElement) {
        return createElement("script", {
          attrs: {
            type: "text/JavaScript",
            src: "../../assets/vendor/bootstrap/js/bootstrap.bundle.min.js",
          },
        });
      },
    },
  },
  created() {
    this.getTideGoodsList();
    this.getSimpleGoodsList();
    this.getSportGoodsList();
    this.getNationGoodsList();
  },

  methods: {
    getTideGoodsList() {
      fetchTideList(this.listTideQuery).then((response) => {
        this.tideGoods = response.data.list;
      });
    },
    getSimpleGoodsList() {
      fetchTideList(this.listSimpleQuery).then((response) => {
        this.simpleGoods = response.data.list;
      });
    },
    getSportGoodsList() {
      fetchTideList(this.listSportQuery).then((response) => {
        this.sportGoods = response.data.list;
      });
    },
    getNationGoodsList() {
      fetchTideList(this.listSportQuery).then((response) => {
        this.nationGoods = response.data.list;
      });
    },

    handleGoodsInfo(id) {
      this.$router.push({
        path: "/goodsDetail",
        query: { id: id },
      });
    },
  },
};
</script>

<style>
@import url(https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i);
@import "../../assets/vendor/icofont/icofont.min.css";
@import "../../assets/vendor/boxicons/css/boxicons.min.css";
@import "../../assets/vendor/owl.carousel/assets/owl.carousel.min.css";
@import "../../assets/vendor/venobox/venobox.css";
@import "../../assets/css/style.css";

.simpleImg-size {
  width: 255px;
  height: 255px;
}

.nationalImg-size {
  width: 255px;
  height: 200px;
}

.img-fluid {
  width: 100%;
  height: 100%;
}

.simple-button {
  margin-top: 30px;
  width: 60px;
  height: 30px;
  border: 0 none;
  font-size: 14px;
  text-align: center;
  font-weight: 500;
  line-height: 1;
  color: #444444;
  background: #f0f0f0;
  border-radius: 50px;
}

.simple-button:hover {
  color: #414c64;
  background: #ffc107;
}

.sport-info {
  margin: 10px 0;
}

.sport-info h6 {
  font-weight: 700;
  font-size: 16px;
  color: #414c64;
}

.sport-info p {
  font-style: italic;
  font-size: 15px;
  margin-bottom: 1px;
  color: #777777;
}

.shopping-cart-button {
  margin-left: 25px;
  margin-bottom: 10px;
  width: 90px;
  height: 25px;
  border: 0 none;
  font-size: 14px;
  text-align: center;
  font-weight: 500;
  line-height: 1;
  color: #444444;
  background: #fafafc;
  border-radius: 50px;
}

.shopping-cart-button:hover {
  color: #414c64;
  background: #ffc107;
}

.sport-button {
  width: 50px;
  height: 25px;
  border: 0 none;
  font-size: 14px;
  text-align: center;
  font-weight: 500;
  line-height: 1;
  color: #444444;
  background: #fafafc;
  border-radius: 50px;
}

.sport-button:hover {
  color: #414c64;
  background: #ffc107;
}
</style>
