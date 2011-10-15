
(ns twitter-post.core
  (import twitter4j.TwitterFactory
          twitter4j.conf.ConfigurationBuilder))

(def conf (ConfigurationBuilder. ))
(.setDebugEnabled conf true)
(.setOAuthConsumerKey conf "hoge")

(def twitter-factory (TwitterFactory.
                      (.build conf)))
(def twitter (.getInstance twitter-factory))
