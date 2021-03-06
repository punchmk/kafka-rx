package com.cj.kafka.rx

import org.apache.kafka.clients.producer.ProducerRecord

case class ProducerMessage[K, V](key: K, value: V, partition: Integer = null) {

  def toProducerRecord(topic: String) = {
    new ProducerRecord[K, V](topic, partition, key, value)
  }

}

class ProducedMessage[K, V, k, v](key: K, value: V, partition: Integer = null, val sourceMessage: Message[k, v])
  extends ProducerMessage(key, value, partition) {
}