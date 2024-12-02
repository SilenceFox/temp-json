(ns json-gen.core
  (:require [cheshire.core :as cheshire]
            [hiccup.core :refer [html]]))

(def calendar-en
  {:weekDays {:sunday "Sunday"
              :monday "Monday"
              :tuesday "Tuesday"
              :wednesday "Wednesday"
              :friday "Friday"
              :saturday "Saturday"}

   :monthNames {:0 "January"
                :1 "February"
                :2 "March"
                :3 "April"
                :4 "May"
                :5 "June"
                :6 "July"
                :7 "August"
                :8 "September"
                :9 "October"
                :10 "November"
                :11 "December"}})

(def page-titles-en {:synaxarion "Synaxarion"
                     :prayers "Prayers"
                     :settings "Settings"
                     :commonPrayers "Daily prayers"
                     :morningPrayers "Morning prayers"
                     :eveningPrayers "Evening prayers"
                     :throughDayPrayers "Throughout the day"
                     :middayPrayers "Midday Prayers"
                     :selectDate "Select a date"
                     :communion "Sacred Communion"
                     :occasionalPrayers "Occasional Prayers"
                     :communionOffice "Before Holy Communion"
                     :communionThanks "Thanksgiving for Holy Communion"})

(def pagedesc-en {:morningPrayers "Prayers for the morning",
                  :throughDayPrayers "Prayers to say throughout the day",
                  :eveningPrayers "Prayers to say before sleep",
                  :confessionInstruction "sobre a confissão",
                  :confessionGuide "para a confissão",
                  :communionOffice "para a Sagrada Comunhão",
                  :communionThanks "pela Sagrada Comunhão",
                  :occasionalPrayers "Prayers for various occasions"})

(def about-page-en-html
  (html
      [:html
       [:head
        [:style "
       body { background-color: #25292e; color: #fff; padding: 0px 90px; padding-bottom: 180px; }
       h1 { font-size: 60px; letter-spacing: 6px; text-align: center; }
       p { font-size: 43px; letter-spacing: 0px; text-align: justify; font-weight: 400; }
       em { color: #999; }
       a { text-decoration: none; color: #72a4f2; } "]]
       [:body
        [:h1 "ABOUT"]
        [:hr]
        [:p [:strong "Praxis"] " is an open-source mobile app designed to help Orthodox Christians have easy access to the liturgical calendar and to their daily prayers. It was built using "
         [:a {:target "_blank" :href "https://expo.dev/"} "Expo"] " and "
         [:a {:target "_blank" :href "https://reactnative.dev/"} "React Native"] "."]
        [:p "The texts currently included are works of the "
         [:a {:target "_blank" :href "https://www.ortodoxia.pt/"} "Russian Orthodox Church in Portugal"] " and the "
         [:a {:target "_blank" :href "https://www.antiochian.org/home"} "Antiochian Orthodox Church in America"] ". If you would like to add more texts or contribute to the development of the app, you can do so by making a pull request on the "
         [:a {:target "_blank" :href "https://github.com/JLucasGaldino/Praxis"} "git repo"] "."]
        [:p "This app was built with the assistance and blessing of Bishop Dom Petru Putreanu of the Russian Archdiocese of Portugal and Spain."]
        [:p "If you would like to support "
         [:a {:target "_blank" :href "https://www.lucasgaldino.com/"} "my work"] ", please consider making a donation, so I can keep improving this app and create others. You can donate by clicking on the button below."]
        [:a {:href "https://ko-fi.com/O5O616HNS2" :target "_blank"}
         [:img {:height "100" :style "border:0px;height:100px;" :src "https://storage.ko-fi.com/cdn/kofi5.png?v=6" :border "0" :alt "Buy Me a Coffee at ko-fi.com"}]]
        [:p "Images are courtesy of "
         [:a {:target "_blank" :href "https://unsplash.com/"} "Unsplash"] ", "
         [:a {:target "_blank" :href "https://www.pexels.com/"} "Pexels"] ", and "
         [:a {:target "_blank" :href "https://pixabay.com/"} "Pixabay"] "."]]]))

(def settings-con-en {:languages "Languages"
                      :languageSelection {:english "English" :portuguese "Portuguese"}
                      :notice "Please understand that since this app is in development it does not yet contain the full prayers in English."
                      :calendar "Calendar"
                      :calendarSelection {:julian "Julian" :gregorian "Gregorian"}
                      :about "About"
                      :aboutPage about-page-en-html})



(def en {:cardContent
         {:commemorations "Commemorations"
          :readings "Readings"}
         :calendar calendar-en
         :pageTitles page-titles-en
         :pageDescriptions pagedesc-en
         :settingsContent settings-con-en})

(def pt {})

(def data {:en en, :pt pt})

(defn -main []
  (let [json-output (cheshire/generate-string data)]
    (spit "output.json" json-output)))

(-main)
