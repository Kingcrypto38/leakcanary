package shark

import shark.HeapObject.HeapClass
import shark.HeapObject.HeapInstance
import shark.HeapObject.HeapObjectArray
import shark.HeapObject.HeapPrimitiveArray

class DelegatingObjectReferenceReader(
  private val classReferenceReader: ReferenceReader<HeapClass>,
  private val instanceReferenceReader: ReferenceReader<HeapInstance>,
  private val objectArrayReferenceReader: ReferenceReader<HeapObjectArray>,
) : ReferenceReader<HeapObject> {
  override fun read(source: HeapObject): Sequence<Reference> {
    return when(source) {
      is HeapClass -> classReferenceReader.read(source)
      is HeapInstance -> instanceReferenceReader.read(source)
      is HeapObjectArray -> objectArrayReferenceReader.read(source)
      // PathFinder typically avoids enqueuing those, unless they're the targeted leaking
      // objects.
      is HeapPrimitiveArray -> emptySequence()
    }
  }
}
