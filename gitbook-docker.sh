#!/bin/bash

set -e

if ! which docker; then echo "Docker is not existing on your machine" >&2
	exit 1
fi

OUT=/dev/stdout
if [[ ${1} == "-q" ]]; then
	OUT=/dev/null
	shift
fi

if [[ ! -f check.txt ]]; then
docker build -f Dockerfile -t gitbook-image .
fi
touch check.txt
> ${OUT}
docker run -it --rm -d gitbook-image bash
#"${@}"
