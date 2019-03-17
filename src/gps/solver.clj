(ns gps.solver
  (:require [gps.school :refer [SCHOOL-OPS
                                SCHOOL-STATE
                                SCHOOL-GOAL]]
            [gps.monkey :refer [MONKEY-OPS
                                MONKEY-STATE
                                MONKEY-GOAL]]
            [clojure.set :refer [difference union]]))

(declare solve!)

(defn apply-op [world op]
  (if-let [preconds (:preconds op)]
    (some-> (solve! world preconds)
            (update :plan #(conj % (:action op)))
            (update :state (fn [s] (-> s
                                       (union (:add-list op))
                                       (difference (:del-list op))))))))

(defn applicable? [goal op]
  (if-let [a (:add-list op)]
    (get a goal)
    false))

(defn achieve [{:keys [state ops] :as world} goal]
  (let [apply-with-world (partial apply-op world)]
    (if (get state goal)
        world
        (some apply-with-world (filter #(applicable? goal %) ops)))))

(defn solve! [world goals]
  (reduce #(achieve %1 %2) world goals))

(defn go! [state ops goals]
  (let [world {:state state
               :ops   ops
               :plan  []}]
    (solve! world goals)))

(defn -main []
  (->> (go!
         SCHOOL-STATE
         SCHOOL-OPS
         SCHOOL-GOAL)
       :plan
       (println "Plan for school:"))
  (println "Go, monkey, go!")
  (->> (go!
         MONKEY-STATE
         MONKEY-OPS
         MONKEY-GOAL)
       :plan
       (println "Monkey's plan:")))
