class Document:
    def __init__(self, filename):
        self.filename = filename

    def __iter__(self):
        with open(self.filename, 'r') as file:
            for line in file:
                for word in line.split():
                    yield word.strip('.,!?";:()').lower()

    def ttr(self):
        tokens = list(self)
        types = set(tokens)
        return len(types) / len(tokens)

# Nutzung der Klasse Document
doc = Document('data/dracula.txt')
print(doc.ttr())

