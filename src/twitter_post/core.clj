(ns twitter-post.core
  (use twitter-post.config)
  (import twitter4j.TwitterFactory
          twitter4j.conf.ConfigurationBuilder))

(def twitter (.. (TwitterFactory.)
                 (getInstance)))

(defn authorization-url-with-token []
  (.setOAuthConsumer twitter
                     consumer-key
                     consumer-secret)
  (let [request-token
        (.getOAuthRequestToken twitter)]
    [(.getAuthorizationURL request-token)
     request-token]))

(defn access-token [token pin]
  (.getOAuthAccessToken twitter token pin))

(defn set-atoken [atoken]
  (.setOAuthAccessToken twitter atoken))

(defn token-with-secret [atoken]
  {:id (.. twitter verifyCredentials getId)
   :token (.getToken atoken)
   :secret (.getTokenSecret atoken)})