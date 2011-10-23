
(ns twitter-post.core
  (use twitter-post.config)
  (import twitter4j.TwitterFactory
          twitter4j.conf.ConfigurationBuilder))

(defn authorization-url []
  (let [twitter-factory (TwitterFactory.)
        twitter (.getInstance twitter-factory)]
    (.setOAuthConsumer twitter
                       consumer-key
                       consumer-secret)
    (let [request-token
          (.getOAuthRequestToken twitter)]
      (.getAuthorizationURL
       request-token))))
  
(prn (authorization-url))